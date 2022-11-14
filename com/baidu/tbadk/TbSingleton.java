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
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
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
import com.baidu.tieba.ah;
import com.baidu.tieba.ao8;
import com.baidu.tieba.c35;
import com.baidu.tieba.d35;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.f35;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.g25;
import com.baidu.tieba.g55;
import com.baidu.tieba.gd8;
import com.baidu.tieba.h25;
import com.baidu.tieba.hf8;
import com.baidu.tieba.hp4;
import com.baidu.tieba.i25;
import com.baidu.tieba.j55;
import com.baidu.tieba.k55;
import com.baidu.tieba.m25;
import com.baidu.tieba.m55;
import com.baidu.tieba.n15;
import com.baidu.tieba.o15;
import com.baidu.tieba.p15;
import com.baidu.tieba.py4;
import com.baidu.tieba.q25;
import com.baidu.tieba.r35;
import com.baidu.tieba.sa9;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.u25;
import com.baidu.tieba.v35;
import com.baidu.tieba.w15;
import com.baidu.tieba.w25;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.tieba.x25;
import com.baidu.tieba.xi;
import com.baidu.tieba.yt4;
import com.baidu.tieba.z25;
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
    public n15 adFloatViewData;
    public long appFirstInstallTime;
    public long appLastUpdateTime;
    public String baiduIdForAnti;
    public boolean browseMode;
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
    public h25 homepageInterestConfigData;
    public i25 hotNotifyConfigData;
    public IconPopData iconPopData;
    public String invokeSource;
    public boolean isAddBanner;
    public boolean isBaiduidCookieSwitch;
    public boolean isBusinessAccount;
    public boolean isCanShowHotSplash;
    public boolean isDanmuSwitchOpen;
    public boolean isFirstEnterBigPicPage;
    public boolean isInFrs;
    public boolean isItemTabVisible;
    public boolean isMercatorRequestFromHomePageTabFeedFragment;
    public boolean isMyTabClicked;
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
    public p15 mAdVertiSementConfigData;
    public int mAnimFpsSyncThreshold;
    public String mBannerText;
    public final String mBaseActivity;
    public final String mBaseFragmentActivity;
    public w15 mBearSidConfigData;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public boolean mCanWebViewActivityShowProgress;
    public r35 mChannelConfigModel;
    public boolean mClipboardDelayTime;
    public HashMap<String, g55> mColourHeaderConfigs;
    public int mCpuFlopsDur;
    public int mCpuThreshold;
    public boolean mEnableBenchmark;
    public final String mFlutterPageActivity;
    public boolean mForceRefreshHomeRecommend;
    public boolean mFrsContentViewLoadingShow;
    public int mFrsCurTabType;
    public ao8 mFrsResponseData;
    public boolean mFrsRootViewLoadingShow;
    public boolean mHasAgreeToPlay;
    public Map<String, Date> mHasShowFid;
    public final BroadcastReceiver mHeadSetStateReceiver;
    public g25 mHomeInsertAdData;
    public j55 mHomeOperateData;
    public List<k55> mHomePageLuckyConfigs;
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
    public boolean mIsNeedShowCommentFloat;
    public int mIsNotchScreen;
    public boolean mIsOpenTrack;
    public boolean mIsOutNeedReuseVideoPlayer;
    public boolean mIsShowVoiceFloat;
    public boolean mIsSplashClick;
    public boolean mIsVideoCardMute;
    public boolean mIsVisitPreviewServer;
    public String mLFUser;
    public String mLFUserTaskId;
    public m55 mLiveActivityGuide;
    public q25 mMainTabPopConfig;
    public MercatorModel.MercatorData mMercatorData;
    public String mMissionEntranceIcon;
    public String mMissionEntranceObjSource;
    public String mMissionEntranceUrl;
    public NewGodData mNewGodData;
    public NewUserRedPackageData mNewUserRedPackageData;
    public yt4 mPbToHomeUpdateData;
    public gd8 mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public String mSampleId;
    public w25 mShakeData;
    public x25 mSharePanelConfData;
    public String mSharePanelText;
    public boolean mShowCallFans;
    public boolean mShowHomeFloatRefreshButton;
    public boolean mShowShoubaiDynamicGuide;
    public boolean mShowVivoBadge;
    public SmallTailThemeData mSmallTailThemeData;
    public boolean mStartGameClicked;
    public TiebaPlusConfigData mTiebaPlusConfigData;
    public boolean mTipsAutoPlayInVideoChannel;
    public boolean mTipsAutoPlayInVideoMiddle;
    public JSONArray mUbsABTestJsonArray;
    public hf8 mUploadAndClearModule;
    public Bitmap mVideoCurrentFrame;
    public LinkedList<hp4> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public f35 mWlConfigData;
    public String mWorldCupSponsorFlag;
    public YYLiveConfig mYYLiveConfig;
    public sa9 mYYLiveTabConfig;
    public boolean needRefreshForumSquare;
    public JSONObject newGodDataJson;
    public boolean personalizedRecSwitchChanged;
    public long pushDialogLoopTime;
    public long pushDialogShowTime;
    public u25 pushStrategyConfig;
    public String pushTid;
    public Bundle reloginVideoMiddleBundle;
    public String schemaForStartOtherAppAfterSwanApp;
    public boolean shouldShowHomeLocalCompleteInfoCard;
    public boolean shouldShowLocalChannelPostAnim;
    public boolean showStampMissionDialog;
    public boolean showedInterestGuide;
    public v35 syncModel;
    public HashMap<String, String> tempStrings;
    public boolean triggerInterestPanelYDaysConfig;
    public z25 upgradePopWindowConfig;
    public UserGrowthTaskListData userGrowthTaskListData;
    public UserPendantData userPendantData;
    public RedIcon videoChannelAttentionRedIcon;
    public RedIcon videoChannelRecommendRedIcon;
    public c35 videoEventsConfig;
    public int videoRedIconInterval;
    public String videoTestType;
    @Nullable
    public d35 voiceRoomConfig;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
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
        this.THREE_DAY_MILLISECOND = ImagesInvalidService.FILE_VALID_TIME;
        this.pushDialogLoopTime = StringHelper.MS_TO_HOUR;
        this.pushDialogShowTime = StringHelper.MS_TO_MIN * 5;
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
        this.mIsNeedShowCommentFloat = false;
        this.appFirstInstallTime = 0L;
        this.appLastUpdateTime = 0L;
        this.activeTimeStamp = 0L;
        this.isAddBanner = false;
        this.browseMode = false;
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
        this.homepageInterestConfigData = null;
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
        this.liveFollowSecondFloor = new ArrayList();
        this.liveIndexSecondFloor = new ArrayList();
        this.isShowRecommendLiveSecondFloor = true;
        this.isShowConcernLiveSecondFloor = true;
        this.lightEmotionInfo = new ArrayList<>();
        this.mFrsResponseData = null;
        this.isFirstEnterBigPicPage = true;
        this.frsItemInfoCache = new HashMap();
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
        setIsOpenTrack(py4.k().h("key_is_open_track", false));
        setProfileGameCenterKey(py4.k().q("profile_swan_app_key", ""));
        setHomePageStyleAbTest(py4.k().l("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(py4.k().q("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(py4.k().q("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(py4.k().q("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(py4.k().h("audit_package_switch", false));
        setBaiduidCookieSwitch(py4.k().h("key_baidu_id_cookie_switch", false));
        setUbsSampleId(py4.k().q("key_ubs_sample_id", ""));
        if (py4.k().l("key_is_show_shoubai_dynamic_guide", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        setShowShoubaiDynamicGuide(z);
        if (py4.k().l("key_home_refresh_button_test", 0) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mShowHomeFloatRefreshButton = z2;
        setClipboardDelayTime(py4.k().h("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        setDanmuSwitchOpen(py4.k().h("key_video_danmu_switch", true));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        ah.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.1
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
        this.mShowVivoBadge = py4.k().h("key_show_vivo_badge", false);
        this.mChannelConfigModel = new r35();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = py4.k().h("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = py4.k().h("has_performed_first_login_test", false);
        this.yyCloudSwitch = py4.k().q("key_yy_cloud_switch", null);
        this.isStartStatUploadImmediately = py4.k().l("key_switch_immediately_upload", 0) == 1;
        SpeedStats.getInstance().setSid(this.mSampleId);
        setWorldCupSponsorFlag(py4.k().q("world_cup_sponsor_flag", ""));
    }

    private String getAdStrWithLimit() {
        InterceptResult invokeV;
        p15 p15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (StringHelper.isTaday(py4.k().m("key_pb_falling_ad_feedback_click_time", 0L)) || (p15Var = this.mAdVertiSementConfigData) == null) {
                return "";
            }
            return p15Var.c();
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
        LinkedList<hp4> linkedList;
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
                this.activeTimeStamp = py4.k().m("key_active_timestamp", 0L);
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

    public p15 getAdVertiSementData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mAdVertiSementConfigData;
        }
        return (p15) invokeV.objValue;
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
                this.baiduIdForAnti = py4.k().q("key_baiduid_for_anti", null);
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

    public r35 getChannelConfigModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.mChannelConfigModel;
        }
        return (r35) invokeV.objValue;
    }

    public boolean getClipboardDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.mClipboardDelayTime;
        }
        return invokeV.booleanValue;
    }

    public HashMap<String, g55> getColourHeaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mColourHeaderConfigs;
        }
        return (HashMap) invokeV.objValue;
    }

    public int getCpuFlopsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mCpuFlopsDur < 0) {
                this.mCpuFlopsDur = py4.k().l("cpu_flops_dura", 0);
            }
            return this.mCpuFlopsDur;
        }
        return invokeV.intValue;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.mCpuThreshold;
        }
        return invokeV.intValue;
    }

    public long getCurrentClickTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.currentClickTime;
        }
        return invokeV.longValue;
    }

    public long getDuXiaoManActivityTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.duXiaoManActivityTimestamp == 0) {
                this.duXiaoManActivityTimestamp = py4.k().m("key_doxiaoman_activity_timestamp", 0L);
            }
            return this.duXiaoManActivityTimestamp;
        }
        return invokeV.longValue;
    }

    public Uri getFirstOpenScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.firstOpenScheme;
        }
        return (Uri) invokeV.objValue;
    }

    public boolean getForceRefreshHomeRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.mForceRefreshHomeRecommend;
        }
        return invokeV.booleanValue;
    }

    public String getFromWhichSearchSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.fromWhichSearchSource;
        }
        return (String) invokeV.objValue;
    }

    public int getFrsCurTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.mFrsCurTabType;
        }
        return invokeV.intValue;
    }

    public Map<String, ItemInfo> getFrsItemInfoCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.frsItemInfoCache;
        }
        return (Map) invokeV.objValue;
    }

    public ao8 getFrsResponseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.mFrsResponseData;
        }
        return (ao8) invokeV.objValue;
    }

    public Map<String, Date> getHasShowTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.mHasShowFid;
        }
        return (Map) invokeV.objValue;
    }

    public o15 getHomeAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            n15 n15Var = this.adFloatViewData;
            if (n15Var != null) {
                return n15Var.a();
            }
            return null;
        }
        return (o15) invokeV.objValue;
    }

    public g25 getHomeInsertAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mHomeInsertAdData;
        }
        return (g25) invokeV.objValue;
    }

    public j55 getHomeOperateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mHomeOperateData;
        }
        return (j55) invokeV.objValue;
    }

    public List<k55> getHomePageLuckyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mHomePageLuckyConfigs;
        }
        return (List) invokeV.objValue;
    }

    public int getHomePageStyleAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.mHomePageStyleAbTest;
        }
        return invokeV.intValue;
    }

    public h25 getHomepageInterestConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.homepageInterestConfigData;
        }
        return (h25) invokeV.objValue;
    }

    public List<String> getHostWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mHostWhiteList;
        }
        return (List) invokeV.objValue;
    }

    public i25 getHotNotifyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.hotNotifyConfigData;
        }
        return (i25) invokeV.objValue;
    }

    public String getHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mHotSearch;
        }
        return (String) invokeV.objValue;
    }

    public String getInvokeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.invokeSource;
        }
        return (String) invokeV.objValue;
    }

    public Boolean getIsJumpFromVideoMiddleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return Boolean.valueOf(this.mIsJumpFromVideoMiddleView);
        }
        return (Boolean) invokeV.objValue;
    }

    public boolean getIsNeedRemindLiveRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.mIsNeedRemindLiveRoom;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.mIsInNeedReuseVideoPlayer;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsNeedShowPbCommentFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.mIsNeedShowCommentFloat;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsOutNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mIsOutNeedReuseVideoPlayer;
        }
        return invokeV.booleanValue;
    }

    public boolean getIsPushOrSchemeLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.isPushOrSchemeLog;
        }
        return invokeV.booleanValue;
    }

    public String getLFUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mLFUser;
        }
        return (String) invokeV.objValue;
    }

    public String getLFUserTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mLFUserTaskId;
        }
        return (String) invokeV.objValue;
    }

    public long getLastResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (this.lastResumeTime == 0) {
                this.lastResumeTime = py4.k().m("last_resume_time", 0L);
            }
            return this.lastResumeTime;
        }
        return invokeV.longValue;
    }

    public ArrayList<LightEmotionData> getLightEmotionInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.lightEmotionInfo;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<AlaLiveInfo> getLiveFollowSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.liveFollowSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    public List<AlaLiveInfo> getLiveIndexSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.liveIndexSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    public q25 getMainTabPopConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.mMainTabPopConfig;
        }
        return (q25) invokeV.objValue;
    }

    public MercatorModel.MercatorData getMercatorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.mMercatorData;
        }
        return (MercatorModel.MercatorData) invokeV.objValue;
    }

    public String getMissionEntranceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.mMissionEntranceIcon;
        }
        return (String) invokeV.objValue;
    }

    public String getMissionEntranceObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.mMissionEntranceObjSource;
        }
        return (String) invokeV.objValue;
    }

    public String getMissionEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.mMissionEntranceUrl;
        }
        return (String) invokeV.objValue;
    }

    public String getModName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            hf8 hf8Var = this.mUploadAndClearModule;
            if (hf8Var == null) {
                return null;
            }
            return hf8Var.a();
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.mNewGodData;
        }
        return (NewGodData) invokeV.objValue;
    }

    public JSONObject getNewGodDataJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.newGodDataJson;
        }
        return (JSONObject) invokeV.objValue;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.mNewUserRedPackageData;
        }
        return (NewUserRedPackageData) invokeV.objValue;
    }

    public o15 getPbAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            n15 n15Var = this.adFloatViewData;
            if (n15Var != null) {
                return n15Var.b();
            }
            return null;
        }
        return (o15) invokeV.objValue;
    }

    public yt4 getPbToHomeUpdateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.mPbToHomeUpdateData;
        }
        return (yt4) invokeV.objValue;
    }

    public gd8 getPcdnConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.mPcdnConfigData;
        }
        return (gd8) invokeV.objValue;
    }

    public int getPersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return py4.k().l("key_personalized_rec_switch", 1);
        }
        return invokeV.intValue;
    }

    public String getProfileGameCenterKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.mProfileGameCenterKey;
        }
        return (String) invokeV.objValue;
    }

    @Modify(description = "配置预览机pub_env参数，1=沙盒环境，2=小流量环境", type = Constants.SHORT_PING_CMD_TYPE)
    public String getPubEnvValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.mPubEnvValue;
        }
        return (String) invokeV.objValue;
    }

    public long getPushDialogLoopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.pushDialogLoopTime;
        }
        return invokeV.longValue;
    }

    public long getPushDialogShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.pushDialogShowTime;
        }
        return invokeV.longValue;
    }

    public u25 getPushStrategyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            u25 u25Var = this.pushStrategyConfig;
            if (u25Var != null) {
                return u25Var;
            }
            return u25.d;
        }
        return (u25) invokeV.objValue;
    }

    public String getPushTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.pushTid;
        }
        return (String) invokeV.objValue;
    }

    public Bundle getReloginVideoMiddleBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.reloginVideoMiddleBundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public String getSampleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.mSampleId;
        }
        return (String) invokeV.objValue;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.schemaForStartOtherAppAfterSwanApp;
        }
        return (String) invokeV.objValue;
    }

    public w25 getShakeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.mShakeData;
        }
        return (w25) invokeV.objValue;
    }

    public x25 getSharePanelConfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.mSharePanelConfData;
        }
        return (x25) invokeV.objValue;
    }

    public String getSharePanelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.mSharePanelText;
        }
        return (String) invokeV.objValue;
    }

    public boolean getShowedInterestGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.showedInterestGuide;
        }
        return invokeV.booleanValue;
    }

    public v35 getSyncModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.syncModel;
        }
        return (v35) invokeV.objValue;
    }

    public TiebaPlusConfigData getTiebaPlusConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.mTiebaPlusConfigData;
        }
        return (TiebaPlusConfigData) invokeV.objValue;
    }

    public JSONArray getUbsABTestJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.mUbsABTestJsonArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public z25 getUpgradePopWindowConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            z25 z25Var = this.upgradePopWindowConfig;
            if (z25Var != null) {
                return z25Var;
            }
            return z25.i;
        }
        return (z25) invokeV.objValue;
    }

    public UserGrowthTaskListData getUserGrowthTaskListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (this.userGrowthTaskListData == null) {
                int l = py4.k().l("key_person_growth_switch", 0);
                UserGrowthTaskListData userGrowthTaskListData = new UserGrowthTaskListData();
                this.userGrowthTaskListData = userGrowthTaskListData;
                userGrowthTaskListData.setGrowthSwitch(l);
            }
            return this.userGrowthTaskListData;
        }
        return (UserGrowthTaskListData) invokeV.objValue;
    }

    @Nullable
    public UserPendantData getUserPendantData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.userPendantData;
        }
        return (UserPendantData) invokeV.objValue;
    }

    public SmallTailThemeData getUserSmallTheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.mSmallTailThemeData;
        }
        return (SmallTailThemeData) invokeV.objValue;
    }

    public RedIcon getVideoChannelAttentionRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.videoChannelAttentionRedIcon;
        }
        return (RedIcon) invokeV.objValue;
    }

    public RedIcon getVideoChannelRecommendRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.videoChannelRecommendRedIcon;
        }
        return (RedIcon) invokeV.objValue;
    }

    public Bitmap getVideoCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.mVideoCurrentFrame;
        }
        return (Bitmap) invokeV.objValue;
    }

    public c35 getVideoEventsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.videoEventsConfig;
        }
        return (c35) invokeV.objValue;
    }

    public LinkedList<hp4> getVideoRecordList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.mVideoWatchTimeRecord;
        }
        return (LinkedList) invokeV.objValue;
    }

    public int getVideoRedIconInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.videoRedIconInterval;
        }
        return invokeV.intValue;
    }

    public String getVideoTestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.videoTestType;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public d35 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            d35 d35Var = this.voiceRoomConfig;
            if (d35Var != null) {
                return d35Var;
            }
            return d35.a;
        }
        return (d35) invokeV.objValue;
    }

    public String getWalletSignLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.mWalletSignLink;
        }
        return (String) invokeV.objValue;
    }

    public f35 getWlConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.mWlConfigData;
        }
        return (f35) invokeV.objValue;
    }

    public int getWorksAddTopicMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.worksAddTopicMaxNum;
        }
        return invokeV.intValue;
    }

    public String getWorldCupSponsorFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.mWorldCupSponsorFlag;
        }
        return (String) invokeV.objValue;
    }

    public YYLiveConfig getYYLiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.mYYLiveConfig;
        }
        return (YYLiveConfig) invokeV.objValue;
    }

    public sa9 getYYLiveTabConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.mYYLiveTabConfig;
        }
        return (sa9) invokeV.objValue;
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.mHasAgreeToPlay;
        }
        return invokeV.booleanValue;
    }

    public boolean hasDownloadEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.hasDownloadEmotion;
        }
        return invokeV.booleanValue;
    }

    public boolean hasPerformedFirstLoginTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.hasPerformedFirstLoginTest;
        }
        return invokeV.booleanValue;
    }

    public boolean isAuditPackageSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.mIsAuditPackageSwitchOn;
        }
        return invokeV.booleanValue;
    }

    public boolean isBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.browseMode;
        }
        return invokeV.booleanValue;
    }

    public boolean isBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.isBusinessAccount;
        }
        return invokeV.booleanValue;
    }

    public boolean isCanWebViewActivityShowProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.mCanWebViewActivityShowProgress;
        }
        return invokeV.booleanValue;
    }

    public boolean isClearOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            hf8 hf8Var = this.mUploadAndClearModule;
            if (hf8Var == null) {
                return false;
            }
            return hf8Var.b();
        }
        return invokeV.booleanValue;
    }

    public boolean isDanmuSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.isDanmuSwitchOpen;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableBenchmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.mEnableBenchmark;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableVideoVerticalPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.enableVideoVerticalPreload;
        }
        return invokeV.booleanValue;
    }

    public boolean isFirstEnterBigPicPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.isFirstEnterBigPicPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isFlutterPluginLoadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.mIsFlutterPluginLoadSuccess;
        }
        return invokeV.booleanValue;
    }

    public boolean isFrsLoadingViewHided() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.mIsOpenTrack;
        }
        return invokeV.booleanValue;
    }

    public boolean isMercatorRequestFromHomePageTabFeedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.isMercatorRequestFromHomePageTabFeedFragment;
        }
        return invokeV.booleanValue;
    }

    public boolean isMyTabClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            return this.isMyTabClicked;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.isNewUser;
        }
        return invokeV.booleanValue;
    }

    public boolean isNewUserRedPackageShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.isNewUserRedPackageShowed;
        }
        return invokeV.booleanValue;
    }

    public boolean isPbPreloadSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            return this.isRecommendPage;
        }
        return invokeV.booleanValue;
    }

    public boolean isShouldShowHomeLocalCompleteInfoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            return this.shouldShowHomeLocalCompleteInfoCard;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowConcernLiveSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.isShowConcernLiveSecondFloor;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowHomeFloatRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return this.mShowHomeFloatRefreshButton;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowRecommendLiveSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            return this.isShowRecommendLiveSecondFloor;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowShoubaiDynamicGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.mShowShoubaiDynamicGuide;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowStartLiveEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            return this.mShowVivoBadge;
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVoiceFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return this.mIsShowVoiceFloat;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            return py4.k().h("local_slide_animation__switch", false);
        }
        return invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            return this.mTipsAutoPlayInVideoChannel;
        }
        return invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            return this.mTipsAutoPlayInVideoMiddle;
        }
        return invokeV.booleanValue;
    }

    public boolean isUploadOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            hf8 hf8Var = this.mUploadAndClearModule;
            if (hf8Var == null) {
                return false;
            }
            return hf8Var.c();
        }
        return invokeV.booleanValue;
    }

    public boolean isUserBan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.isUserBan;
        }
        return invokeV.booleanValue;
    }

    public boolean isUserGrowthOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.mIsVideoCardMute;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoChannelRelogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            return this.isVideoChannelRelogin;
        }
        return invokeV.booleanValue;
    }

    @Modify(description = "是否访问预览机", type = Constants.SHORT_PING_CMD_TYPE)
    public boolean isVisitPreviewServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) {
            return this.mIsVisitPreviewServer;
        }
        return invokeV.booleanValue;
    }

    public boolean isYYSwitchStatusIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy");
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadMoreLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void registerScreenSizeChangeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048735, this) == null) {
            ah.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.3
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
        if (interceptable == null || interceptable.invokeV(1048738, this) == null) {
            py4.k().x("key_home_recommend_item_click_time", System.currentTimeMillis());
        }
    }

    public void setActiveTimeStamp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048739, this) == null) && getActiveTimeStamp() == 0) {
            py4.k().x("key_active_timestamp", System.currentTimeMillis());
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
            this.mEnableBenchmark = py4.k().h("enable_benchmark", true);
            this.mCpuThreshold = py4.k().l("cpu_flops_dura_threshold", Integer.MAX_VALUE);
            this.mAnimFpsSyncThreshold = py4.k().l("anim_avg_fps_threshold", 0);
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
            if (xi.isEmpty(str)) {
                return -1;
            }
            return py4.k().l(str, -1);
        }
        return invokeL.intValue;
    }

    public String getTempString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048661, this, str)) == null) {
            return this.tempStrings.get(str);
        }
        return (String) invokeL.objValue;
    }

    public String getUserGrowthWeight(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048688, this, str)) == null) {
            if (xi.isEmpty(str) || getAnimComputedFps(str) < 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048694, this, activity)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, activity)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048726, this, str)) == null) {
            if (StringUtils.isNull(str) || !isUserGrowthOpen() || (userGrowthTaskData = getUserGrowthTaskData(str)) == null || userGrowthTaskData.getDotaskStatus() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void removeAcceleratorServer(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048736, this, str) == null) && this.mAcceleratorMap.containsKey(str)) {
            this.mAcceleratorMap.remove(str);
        }
    }

    public void removeTempString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, str) == null) {
            this.tempStrings.remove(str);
        }
    }

    public void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, str) == null) {
            this.mActivityId = str;
        }
    }

    public void setAdFloatViewData(n15 n15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, n15Var) == null) {
            this.adFloatViewData = n15Var;
        }
    }

    public void setAdVertiSementData(p15 p15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, p15Var) == null) {
            this.mAdVertiSementConfigData = p15Var;
        }
    }

    public void setAnimAverageFpsThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i) == null) {
            this.mAnimFpsSyncThreshold = i;
            py4.k().w("anim_avg_fps_threshold", i);
        }
    }

    public void setAuditPackageSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
            this.mIsAuditPackageSwitchOn = z;
        }
    }

    public void setBaiduIdForAnti(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048748, this, str) == null) && py4.k().q("key_baiduid_for_anti", null) == null) {
            py4.k().y("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBaiduidCookieSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048749, this, i) == null) {
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            this.isBaiduidCookieSwitch = z;
        }
    }

    public void setBannerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, str) == null) {
            this.mBannerText = str;
        }
    }

    public void setBrowseMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z) == null) {
            this.browseMode = z;
        }
    }

    public void setBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048753, this, z) == null) {
            this.isBusinessAccount = z;
        }
    }

    public void setCanShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z) == null) {
            this.canShowPermDlg = z;
        }
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z) == null) {
            this.mCanWebViewActivityShowProgress = z;
        }
    }

    public void setChannelConfigModel(r35 r35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048756, this, r35Var) == null) {
            this.mChannelConfigModel = r35Var;
        }
    }

    public void setClipboardDelayTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z) == null) {
            this.mClipboardDelayTime = z;
        }
    }

    public void setColourHeaderConfig(HashMap<String, g55> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, hashMap) == null) {
            this.mColourHeaderConfigs = hashMap;
        }
    }

    public void setCpuFlopsDuration(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048759, this, i) != null) || i < 0) {
            return;
        }
        this.mCpuFlopsDur = i;
        py4.k().w("cpu_flops_dura", i);
    }

    public void setCpuThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048760, this, i) == null) {
            this.mCpuThreshold = i;
            py4.k().w("cpu_flops_dura_threshold", i);
        }
    }

    public void setCurrentClickTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048761, this, j) == null) {
            this.currentClickTime = j;
        }
    }

    public void setDanmuSwitchOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048762, this, z) == null) {
            this.isDanmuSwitchOpen = z;
            py4.k().u("key_video_danmu_switch", z);
        }
    }

    public void setDuXiaoManActivityTimestamp(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048763, this, j) == null) && j != this.duXiaoManActivityTimestamp) {
            this.duXiaoManActivityTimestamp = j;
            py4.k().x("key_doxiaoman_activity_timestamp", j);
        }
    }

    public void setEnableBenchmark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048764, this, z) == null) {
            this.mEnableBenchmark = z;
            py4.k().u("enable_benchmark", z);
        }
    }

    public void setEnableVideoVerticalPreload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
            this.enableVideoVerticalPreload = z;
        }
    }

    public void setFirstEnterBigPicPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
            this.isFirstEnterBigPicPage = z;
        }
    }

    public void setFirstOpenScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, uri) == null) {
            this.firstOpenScheme = uri;
        }
    }

    public void setFlutterPluginLoadSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z) == null) {
            this.mIsFlutterPluginLoadSuccess = z;
        }
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z) == null) {
            this.mForceRefreshHomeRecommend = z;
        }
    }

    public void setFromWhichSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, str) == null) {
            this.fromWhichSearchSource = str;
        }
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048771, this, z) == null) {
            this.mFrsContentViewLoadingShow = z;
        }
    }

    public void setFrsCurTabType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048772, this, i) == null) {
            this.mFrsCurTabType = i;
        }
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048774, this, z) == null) {
            this.mFrsRootViewLoadingShow = z;
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048775, this, z) == null) {
            this.mHasAgreeToPlay = z;
        }
    }

    public void setHasDownloadEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048776, this, z) == null) {
            this.hasDownloadEmotion = z;
        }
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z) == null) {
            this.hasPerformedFirstLoginTest = z;
            py4.k().u("has_performed_first_login_test", z);
        }
    }

    public void setHasShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048778, this, z) == null) {
            this.hasShowPermDlg = z;
        }
    }

    public void setHasShowTip(Map<String, Date> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, map) == null) {
            this.mHasShowFid = map;
        }
    }

    public void setHomeInsertAdData(g25 g25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, g25Var) == null) {
            this.mHomeInsertAdData = g25Var;
        }
    }

    public void setHomeOperateData(j55 j55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, j55Var) == null) {
            this.mHomeOperateData = j55Var;
        }
    }

    public void setHomePageLuckyConfig(List<k55> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, list) == null) {
            this.mHomePageLuckyConfigs = list;
        }
    }

    public void setHomePageStyleAbTest(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048783, this, i) == null) {
            this.mHomePageStyleAbTest = i;
        }
    }

    public void setHomepageInterestConfig(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, h25Var) == null) {
            this.homepageInterestConfigData = h25Var;
        }
    }

    public void setHostWhiteList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, list) == null) {
            this.mHostWhiteList = list;
        }
    }

    public void setHotNotifyConfig(i25 i25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048786, this, i25Var) == null) {
            this.hotNotifyConfigData = i25Var;
        }
    }

    public void setHotSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, str) == null) {
            this.mHotSearch = str;
        }
    }

    public void setIconPopData(IconPopData iconPopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, iconPopData) == null) {
            this.iconPopData = iconPopData;
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048789, this, str) == null) {
            this.invokeSource = str;
        }
    }

    public void setIsJumpFromVideoMiddleView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048790, this, z) == null) {
            this.mIsJumpFromVideoMiddleView = z;
        }
    }

    public void setIsNeedRemindLiveRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048791, this, z) == null) {
            this.mIsNeedRemindLiveRoom = z;
        }
    }

    public void setIsNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048792, this, z) == null) {
            this.mIsInNeedReuseVideoPlayer = z;
        }
    }

    public void setIsNeedShowPbCommentFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048793, this, z) == null) {
            this.mIsNeedShowCommentFloat = z;
        }
    }

    public void setIsOpenTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048794, this, z) == null) {
            this.mIsOpenTrack = z;
        }
    }

    public void setIsOutNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048795, this, z) == null) {
            this.mIsOutNeedReuseVideoPlayer = z;
        }
    }

    public void setIsRecommendPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048796, this, z) == null) {
            this.isRecommendPage = z;
        }
    }

    public void setLFUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, str) == null) {
            this.mLFUser = str;
        }
    }

    public void setLFUserTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, str) == null) {
            this.mLFUserTaskId = str;
        }
    }

    public void setLastResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048799, this, j) == null) {
            this.lastResumeTime = j;
        }
    }

    public void setLevePopData(LevePopData levePopData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048800, this, levePopData) == null) {
            this.levePopData = levePopData;
        }
    }

    public void setLightEmotionInfo(ArrayList<LightEmotionData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, arrayList) == null) {
            this.lightEmotionInfo.clear();
            this.lightEmotionInfo.addAll(arrayList);
        }
    }

    public void setLiveFollowSecondFloor(List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048802, this, list) == null) {
            this.liveFollowSecondFloor.clear();
            this.liveFollowSecondFloor.addAll(list);
        }
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, hashMap) == null) {
            this.liveForumMap = hashMap;
        }
    }

    public void setLiveIndexSecondFloor(List<AlaLiveInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, list) == null) {
            this.liveIndexSecondFloor.clear();
            this.liveIndexSecondFloor.addAll(list);
        }
    }

    public void setMainTabPopConfig(q25 q25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, q25Var) == null) {
            this.mMainTabPopConfig = q25Var;
        }
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, mercatorData) == null) {
            this.mMercatorData = mercatorData;
        }
    }

    public void setMercatorRequestFromHomePageTabFeedFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048807, this, z) == null) {
            this.isMercatorRequestFromHomePageTabFeedFragment = z;
        }
    }

    public void setMissionEntranceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048808, this, str) == null) {
            this.mMissionEntranceIcon = str;
        }
    }

    public void setMissionEntranceObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048809, this, str) == null) {
            this.mMissionEntranceObjSource = str;
        }
    }

    public void setMissionEntranceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, str) == null) {
            this.mMissionEntranceUrl = str;
        }
    }

    public void setMyTabClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048811, this, z) == null) {
            this.isMyTabClicked = z;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048812, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setNewGodDataJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, jSONObject) == null) {
            this.newGodDataJson = jSONObject;
        }
    }

    public void setNewUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048814, this, z) == null) {
            this.isNewUser = z;
        }
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, newUserRedPackageData) == null) {
            this.mNewUserRedPackageData = newUserRedPackageData;
        }
    }

    public void setNewUserRedPackageShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048816, this, z) == null) {
            this.isNewUserRedPackageShowed = z;
            py4.k().u("key_task_system_new_user_popup_show_number", z);
        }
    }

    public void setPbToHomeUpdateData(yt4 yt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, yt4Var) == null) {
            this.mPbToHomeUpdateData = yt4Var;
        }
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, jSONObject) == null) {
            if (this.mPcdnConfigData == null) {
                this.mPcdnConfigData = new gd8();
            }
            this.mPcdnConfigData.d(jSONObject);
        }
    }

    public void setProfileGameCenterKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048819, this, str) == null) {
            this.mProfileGameCenterKey = str;
        }
    }

    public void setPubEnvValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048820, this, str) == null) {
            this.mPubEnvValue = str;
        }
    }

    public void setPushDialogLoopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048821, this, j) == null) {
            this.pushDialogLoopTime = j;
        }
    }

    public void setPushDialogShowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048822, this, j) == null) {
            this.pushDialogShowTime = j;
        }
    }

    public void setPushOrSchemeLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048823, this, z) == null) {
            this.isPushOrSchemeLog = z;
        }
    }

    public void setPushStrategyConfig(u25 u25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048824, this, u25Var) == null) {
            this.pushStrategyConfig = u25Var;
        }
    }

    public void setPushTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048825, this, str) == null) {
            this.pushTid = str;
        }
    }

    public void setReloginVideoMiddleBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048826, this, bundle) == null) {
            this.reloginVideoMiddleBundle = bundle;
        }
    }

    public void setSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048828, this, str) == null) {
            this.schemaForStartOtherAppAfterSwanApp = str;
        }
    }

    public void setShakeData(w25 w25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048829, this, w25Var) == null) {
            this.mShakeData = w25Var;
        }
    }

    public void setSharePanelConfData(x25 x25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048830, this, x25Var) == null) {
            this.mSharePanelConfData = x25Var;
        }
    }

    public void setSharePanelText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048831, this, str) == null) {
            this.mSharePanelText = str;
        }
    }

    public void setShouldShowHomeLocalCompleteInfoCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048832, this, z) == null) {
            this.shouldShowHomeLocalCompleteInfoCard = z;
        }
    }

    public void setShowConcernLiveSecondFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048833, this, z) == null) {
            this.isShowConcernLiveSecondFloor = z;
        }
    }

    public void setShowRecommendLiveSecondFloor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048834, this, z) == null) {
            this.isShowRecommendLiveSecondFloor = z;
        }
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048835, this, z) == null) {
            this.mShowShoubaiDynamicGuide = z;
        }
    }

    public void setShowVoiceFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048836, this, z) == null) {
            this.mIsShowVoiceFloat = z;
        }
    }

    public void setShowedInterestGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048837, this, z) == null) {
            this.showedInterestGuide = z;
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048838, this, z) == null) {
            py4.k().u("local_slide_animation__switch", z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
        }
    }

    public void setSyncModel(v35 v35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048839, this, v35Var) == null) {
            this.syncModel = v35Var;
        }
    }

    public void setSyncYYSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048840, this, z) == null) {
            this.isYYLive = Boolean.valueOf(z);
            py4 k = py4.k();
            k.u("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void setTiebaPlusConfigData(TiebaPlusConfigData tiebaPlusConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048842, this, tiebaPlusConfigData) == null) {
            this.mTiebaPlusConfigData = tiebaPlusConfigData;
        }
    }

    public void setTipsAutoPlayInVideoChannel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048843, this, z) == null) {
            this.mTipsAutoPlayInVideoChannel = z;
        }
    }

    public void setTipsAutoPlayInVideoMiddle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048844, this, z) == null) {
            this.mTipsAutoPlayInVideoMiddle = z;
        }
    }

    public void setUbsABTestJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048845, this, jSONArray) == null) {
            this.mUbsABTestJsonArray = jSONArray;
        }
    }

    public void setUpgradePopWindowConfig(z25 z25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048846, this, z25Var) == null) {
            this.upgradePopWindowConfig = z25Var;
        }
    }

    public void setUploadAndClearModule(hf8 hf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048847, this, hf8Var) == null) {
            this.mUploadAndClearModule = hf8Var;
        }
    }

    public void setUserBan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048848, this, z) == null) {
            this.isUserBan = z;
        }
    }

    public void setUserPendantData(@NonNull UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048850, this, userPendantData) == null) {
            this.userPendantData = userPendantData;
        }
    }

    public void setUserSmallTheme(SmallTailThemeData smallTailThemeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048851, this, smallTailThemeData) == null) {
            this.mSmallTailThemeData = smallTailThemeData;
        }
    }

    public void setVideoCardMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048852, this, z) == null) {
            this.mIsVideoCardMute = z;
        }
    }

    public void setVideoChannelRelogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048855, this, z) == null) {
            this.isVideoChannelRelogin = z;
        }
    }

    public void setVideoCurrentFrame(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048856, this, bitmap) == null) {
            this.mVideoCurrentFrame = bitmap;
        }
    }

    public void setVideoEventsConfig(c35 c35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048857, this, c35Var) == null) {
            c35 c35Var2 = this.videoEventsConfig;
            if (c35Var2 == null) {
                this.videoEventsConfig = c35Var;
            } else if (!c35Var2.a(c35Var)) {
                this.videoEventsConfig = c35Var;
            }
        }
    }

    public void setVideoRedIconInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048858, this, i) == null) {
            this.videoRedIconInterval = i;
        }
    }

    public void setVideoTestType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048859, this, str) == null) {
            this.videoTestType = str;
        }
    }

    public void setVisitPreviewServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048860, this, z) == null) {
            this.mIsVisitPreviewServer = z;
        }
    }

    public void setVoiceRoomConfig(@Nullable d35 d35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048861, this, d35Var) == null) {
            this.voiceRoomConfig = d35Var;
        }
    }

    public void setWalletSignLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048862, this, str) == null) {
            this.mWalletSignLink = str;
        }
    }

    public void setWlConfigData(f35 f35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048863, this, f35Var) == null) {
            this.mWlConfigData = f35Var;
        }
    }

    public void setWorksAddTopicMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048864, this, i) == null) {
            this.worksAddTopicMaxNum = i;
        }
    }

    public void setWorldCupSponsorFlag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048865, this, str) == null) {
            this.mWorldCupSponsorFlag = str;
        }
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048866, this, yYLiveConfig) == null) {
            this.mYYLiveConfig = yYLiveConfig;
        }
    }

    public void setYYLiveTabConfig(sa9 sa9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048867, this, sa9Var) == null) {
            this.mYYLiveTabConfig = sa9Var;
        }
    }

    public void setYyCloudSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048868, this, str) == null) {
            this.yyCloudSwitch = str;
            py4.k().y("key_yy_cloud_switch", str);
        }
    }

    public boolean canShowPermDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long m = py4.k().m("key_first_enter_app_timestamp", 0L);
            if (this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - m > ImagesInvalidService.FILE_VALID_TIME) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.isYYLive == null) {
                py4 k = py4.k();
                this.isYYLive = Boolean.valueOf(k.h("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
            }
            return this.isYYLive.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimEnable() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            boolean z2 = false;
            if (py4.k().l("slide_local_switch_is_clicked", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (py4.k().l("sync_slide_animation__switch", 0) == 1) {
                z2 = true;
            }
            boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
            if (z) {
                return isSlideAnimLocalSwitchOn;
            }
            if (z2 != isSlideAnimLocalSwitchOn) {
                py4.k().u("local_slide_animation__switch", z2);
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public void onAccountChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            py4 k = py4.k();
            this.isYYLive = Boolean.valueOf(k.h("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
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
            if (xi.isEmpty(str)) {
                return 0;
            }
            py4 k = py4.k();
            return Integer.valueOf(k.l(str + "_anim_benchmark_avg_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public Integer getAnimAvgFpsCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (xi.isEmpty(str)) {
                return 0;
            }
            py4 k = py4.k();
            return Integer.valueOf(k.l(str + "_anim_benchmark_times_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public boolean isAnimEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048687, this, str)) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048849, this, userGrowthTaskListData) == null) {
            this.userGrowthTaskListData = userGrowthTaskListData;
            if (userGrowthTaskListData != null) {
                py4.k().w("key_person_growth_switch", userGrowthTaskListData.getGrowthSwitch());
            } else {
                py4.k().D("key_person_growth_switch");
            }
            py4.k().u("key_person_growth_share_switch", false);
        }
    }

    public void setVideoChannelRecommendRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048854, this, redIcon) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            py4 k = py4.k();
            String q = k.q("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), "");
            if (!StringUtils.isNull(q)) {
                this.iconPopData = (IconPopData) DataExt.toEntity(q, IconPopData.class);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            py4 k = py4.k();
            String q = k.q("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), "");
            if (!StringUtils.isNull(q)) {
                this.levePopData = (LevePopData) DataExt.toEntity(q, LevePopData.class);
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
        if ((interceptable != null && interceptable.invokeV(1048869, this) != null) || !this.mStartGameClicked) {
            return;
        }
        this.mStartGameClicked = false;
        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", "15471320").param("obj_source", "game_lauch_screen").param("obj_name", "可口大冒险").param("obj_param1", 1));
    }

    public boolean interestGuideShowCountInLimit(String str, m25 m25Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048686, this, str, m25Var)) == null) {
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
                if (i <= m25Var.c) {
                    if (i2 >= m25Var.d - 1) {
                        return false;
                    }
                    i2++;
                } else if (i2 < m25Var.d) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            m25 interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
            if (interestBoardConfigData == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long m = py4.k().m("key_new_user_logon_time", 0L);
            long m2 = py4.k().m("key_home_recommend_item_click_time", 0L);
            long m3 = py4.k().m("key_select_interest_flag", 0L);
            long m4 = py4.k().m("key_app_launch_time", 0L);
            String q = py4.k().q("key_interest_guide_show", "");
            boolean isSameDay = TimeHelper.isSameDay(System.currentTimeMillis() - (interestBoardConfigData.a * 86400000), m);
            boolean isTargetTimeInTimeBlock = TimeHelper.isTargetTimeInTimeBlock(m2, m, System.currentTimeMillis());
            int i = (int) (((((currentTimeMillis - m4) / 1000) / 60) / 60) / 24);
            if (isSameDay && !isTargetTimeInTimeBlock) {
                j = 0;
                if (m3 == 0) {
                    z = true;
                    if (m4 == j && i >= interestBoardConfigData.b) {
                        this.triggerInterestPanelYDaysConfig = true;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((!z || z2) && interestGuideShowCountInLimit(q, interestBoardConfigData) && !getShowedInterestGuide()) {
                        return true;
                    }
                    return false;
                }
            } else {
                j = 0;
            }
            z = false;
            if (m4 == j) {
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
        if ((interceptable != null && interceptable.invokeLI(1048733, this, str, i) != null) || xi.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        boolean z = false;
        hp4 hp4Var = null;
        int i2 = size - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                break;
            }
            hp4 hp4Var2 = this.mVideoWatchTimeRecord.get(i3);
            if (str.equals(hp4Var2.a())) {
                if (hp4Var2.b() == i) {
                    return;
                }
                if (i3 == i2) {
                    z = true;
                }
                hp4Var = hp4Var2;
            } else {
                i3--;
            }
        }
        if (hp4Var != null) {
            hp4Var.c(i);
            if (!z) {
                this.mVideoWatchTimeRecord.remove(hp4Var);
                this.mVideoWatchTimeRecord.addLast(hp4Var);
                return;
            }
            return;
        }
        hp4 hp4Var3 = new hp4(str, i);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(hp4Var3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(hp4Var3);
    }

    public void recordAcceleratorServer(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048734, this, str, str2) == null) {
            this.mAcceleratorMap.put(str, str2);
        }
    }

    public void setAnimAvgFps(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048744, this, str, i) == null) && !xi.isEmpty(str) && i >= 0) {
            py4 k = py4.k();
            k.w(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public void setAnimAvgFpsCount(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048745, this, str, i) == null) && !xi.isEmpty(str) && i >= 0) {
            py4 k = py4.k();
            k.w(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setAnimComputedFps(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048746, this, str, i) != null) || xi.isEmpty(str)) {
            return;
        }
        py4.k().w(str, i);
        if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
            setSlideAnimLocalSwitch(false);
        }
    }

    public void setTempString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048841, this, str, str2) == null) {
            this.tempStrings.put(str, str2);
        }
    }

    public void setBaiduidCookieSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.isBaiduidCookieSwitch = z;
        }
    }

    public void setFrsResponseData(ao8 ao8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, ao8Var) == null) {
            this.mFrsResponseData = ao8Var;
            if (ao8Var != null && ao8Var.getForum() != null && !TextUtils.isEmpty(ao8Var.getForum().getName())) {
                if (ao8Var.itemInfo != null) {
                    this.frsItemInfoCache.put(ao8Var.getForum().getName(), ao8Var.itemInfo);
                } else {
                    this.frsItemInfoCache.remove(ao8Var.getForum().getName());
                }
            }
        }
    }

    public void setVideoChannelAttentionRedIcon(RedIcon redIcon) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048853, this, redIcon) == null) {
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
