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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.diskCache.ImagesInvalidService;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.frs.accelerator.PkgNameAndNodeInfoData;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.by4;
import com.repackage.cy4;
import com.repackage.ex4;
import com.repackage.ey4;
import com.repackage.h05;
import com.repackage.hl4;
import com.repackage.hy4;
import com.repackage.iy4;
import com.repackage.k05;
import com.repackage.ky4;
import com.repackage.l05;
import com.repackage.m09;
import com.repackage.n05;
import com.repackage.oi;
import com.repackage.ox4;
import com.repackage.px4;
import com.repackage.qg;
import com.repackage.t68;
import com.repackage.t88;
import com.repackage.tx4;
import com.repackage.up4;
import com.repackage.vw4;
import com.repackage.vy4;
import com.repackage.ww4;
import com.repackage.xw4;
import com.repackage.yt4;
import com.repackage.yy4;
import com.repackage.zx4;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.VideoRedIcon.RedIcon;
@ModifyClass
/* loaded from: classes2.dex */
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
    public static int loginFrom = -1;
    public static TbSingleton mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final long THREE_DAY_MILLISECOND;
    public PkgNameAndNodeInfoData acceleratorData;
    public long acceleratorItemId;
    public long activeTimeStamp;
    public vw4 adFloatViewData;
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
    public boolean hasDownloadEmotion;
    public boolean hasPerformInterestPanelShow;
    public boolean hasPerformedFirstLoginTest;
    public boolean hasShowPermDlg;
    public px4 homepageInterestConfigData;
    public String invokeSource;
    public boolean isAddBanner;
    public boolean isBaiduidCookieSwitch;
    public boolean isBusinessAccount;
    public boolean isCanShowHotSplash;
    public boolean isDanmuSwitchOpen;
    public boolean isExceptInsertAdDiaShow;
    public boolean isInFrs;
    public boolean isItemTabVisible;
    public boolean isMercatorRequestFromHomePageTabFeedFragment;
    public boolean isNewUser;
    public boolean isNewUserRedPackageShowed;
    public boolean isRecommendPage;
    public boolean isShowBackLabel;
    public boolean isStartStatUploadImmediately;
    public String isSwitchActivity;
    public boolean isUserBan;
    public boolean isVideoChannelRelogin;
    public Boolean isYYLive;
    public long lastResumeTime;
    public HashMap<Long, String> liveForumMap;
    public final HashMap<String, String> mAcceleratorMap;
    public String mActivityId;
    public xw4 mAdVertiSementConfigData;
    public int mAnimFpsSyncThreshold;
    public String mBannerText;
    public final String mBaseActivity;
    public final String mBaseFragmentActivity;
    public ex4 mBearSidConfigData;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public boolean mCanWebViewActivityShowProgress;
    public vy4 mChannelConfigModel;
    public boolean mClipboardDelayTime;
    public HashMap<String, h05> mColourHeaderConfigs;
    public int mCpuFlopsDur;
    public int mCpuThreshold;
    public boolean mEnableBenchmark;
    public final String mFlutterPageActivity;
    public boolean mForceRefreshHomeRecommend;
    public boolean mFrsContentViewLoadingShow;
    public int mFrsCurTabType;
    public boolean mFrsRootViewLoadingShow;
    public boolean mHasAgreeToPlay;
    public final BroadcastReceiver mHeadSetStateReceiver;
    public ox4 mHomeInsertAdData;
    public k05 mHomeOperateData;
    public List<l05> mHomePageLuckyConfigs;
    public int mHomePageStyleAbTest;
    public List<String> mHostWhiteList;
    public String mHotSearch;
    public boolean mIsAuditPackageSwitchOn;
    public int mIsCutoutScreen;
    public boolean mIsFlutterPluginLoadSuccess;
    public boolean mIsForceLayoutMaintab;
    public boolean mIsFromFeedVideoClick;
    public boolean mIsInNeedReuseVideoPlayer;
    public boolean mIsJumpFromVideoMiddleView;
    public boolean mIsNeedRemindLiveRoom;
    public boolean mIsNeedShowCommentFloat;
    public int mIsNotchScreen;
    public boolean mIsOpenTrack;
    public boolean mIsOutNeedReuseVideoPlayer;
    public boolean mIsShowVoiceFloat;
    public boolean mIsVideoCardMute;
    public boolean mIsVisitPreviewServer;
    public String mLFUser;
    public String mLFUserTaskId;
    public n05 mLiveActivityGuide;
    public MercatorModel.MercatorData mMercatorData;
    public String mMissionEntranceIcon;
    public String mMissionEntranceObjSource;
    public String mMissionEntranceUrl;
    public NewGodData mNewGodData;
    public NewUserRedPackageData mNewUserRedPackageData;
    public up4 mPbToHomeUpdateData;
    public t68 mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public String mSampleId;
    public by4 mShakeData;
    public cy4 mSharePanelConfData;
    public String mSharePanelText;
    public boolean mShowCallFans;
    public boolean mShowHomeFloatRefreshButton;
    public boolean mShowShoubaiDynamicGuide;
    public boolean mShowVivoBadge;
    public boolean mStartGameClicked;
    public TiebaPlusConfigData mTiebaPlusConfigData;
    public boolean mTipsAutoPlayInVideoChannel;
    public boolean mTipsAutoPlayInVideoMiddle;
    public JSONArray mUbsABTestJsonArray;
    public t88 mUploadAndClearModule;
    public Bitmap mVideoCurrentFrame;
    public LinkedList<hl4> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public ky4 mWlConfigData;
    public YYLiveConfig mYYLiveConfig;
    public m09 mYYLiveTabConfig;
    public boolean needRefreshForumSquare;
    public boolean personalizedRecSwitchChanged;
    public long pushDialogLoopTime;
    public long pushDialogShowTime;
    public zx4 pushStrategyConfig;
    public Bundle reloginVideoMiddleBundle;
    public String schemaForStartOtherAppAfterSwanApp;
    public boolean shouldShowHomeLocalCompleteInfoCard;
    public boolean shouldShowLocalChannelPostAnim;
    public boolean showStampMissionDialog;
    public boolean showedInterestGuide;
    public yy4 syncModel;
    public HashMap<String, String> tempStrings;
    public boolean triggerInterestPanelYDaysConfig;
    public ey4 upgradePopWindowConfig;
    public RedIcon videoChannelAttentionRedIcon;
    public RedIcon videoChannelRecommendRedIcon;
    public hy4 videoEventsConfig;
    public int videoRedIconInterval;
    public String videoTestType;
    @Nullable
    public iy4 voiceRoomConfig;
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

    public TbSingleton() {
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
        this.isExceptInsertAdDiaShow = false;
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
                    boolean z = false;
                    if (intent.getIntExtra("state", 0) != 0 && intent.getIntExtra("state", 0) == 1) {
                        z = true;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921398, Boolean.valueOf(z)));
                }
            }
        };
        this.personalizedRecSwitchChanged = false;
        setIsOpenTrack(yt4.k().h("key_is_open_track", false));
        setProfileGameCenterKey(yt4.k().q("profile_swan_app_key", ""));
        setHomePageStyleAbTest(yt4.k().l("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(yt4.k().q("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(yt4.k().q("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(yt4.k().q("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(yt4.k().h("audit_package_switch", false));
        setBaiduidCookieSwitch(yt4.k().h("key_baidu_id_cookie_switch", false));
        setUbsSampleId(yt4.k().q("key_ubs_sample_id", ""));
        setShowShoubaiDynamicGuide(yt4.k().l("key_is_show_shoubai_dynamic_guide", 0) == 1);
        this.mShowHomeFloatRefreshButton = yt4.k().l("key_home_refresh_button_test", 0) == 1;
        setClipboardDelayTime(yt4.k().h("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        setDanmuSwitchOpen(yt4.k().h("key_video_danmu_switch", true));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        qg.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.1
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
        this.mShowVivoBadge = yt4.k().h("key_show_vivo_badge", false);
        this.mChannelConfigModel = new vy4();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = yt4.k().h("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = yt4.k().h("has_performed_first_login_test", false);
        this.yyCloudSwitch = yt4.k().q("key_yy_cloud_switch", null);
        this.isStartStatUploadImmediately = yt4.k().l("key_switch_immediately_upload", 0) == 1;
    }

    private String getAdStrWithLimit() {
        InterceptResult invokeV;
        xw4 xw4Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (StringHelper.isTaday(yt4.k().m("key_pb_falling_ad_feedback_click_time", 0L)) || (xw4Var = this.mAdVertiSementConfigData) == null) ? "" : xw4Var.c() : (String) invokeV.objValue;
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

    public static TbSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(65541, this) == null) && this.yyCloudSwitch == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
            this.yyCloudSwitch = "";
        }
    }

    private void initBenchmarkData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
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
            this.mEnableBenchmark = yt4.k().h("enable_benchmark", true);
            this.mCpuThreshold = yt4.k().l("cpu_flops_dura_threshold", Integer.MAX_VALUE);
            this.mAnimFpsSyncThreshold = yt4.k().l("anim_avg_fps_threshold", 0);
        }
    }

    private void setUbsSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public boolean canShowPermDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - yt4.k().m("key_first_enter_app_timestamp", 0L) > ImagesInvalidService.FILE_VALID_TIME;
        }
        return invokeV.booleanValue;
    }

    public boolean checkLiveForumByFid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j))) : invokeJ.booleanValue;
    }

    public void clearVideoRecord() {
        LinkedList<hl4> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (linkedList = this.mVideoWatchTimeRecord) == null) {
            return;
        }
        linkedList.clear();
    }

    public String getAcceleratorServer(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.mAcceleratorMap.containsKey(str) ? this.mAcceleratorMap.get(str) : "" : (String) invokeL.objValue;
    }

    public long getActiveTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.activeTimeStamp == 0) {
                this.activeTimeStamp = yt4.k().m("key_active_timestamp", 0L);
            }
            return this.activeTimeStamp;
        }
        return invokeV.longValue;
    }

    public String getActivityId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mActivityId : (String) invokeV.objValue;
    }

    public String getAdVertiComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? getAdStrWithLimit() : (String) invokeV.objValue;
    }

    public xw4 getAdVertiSementData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdVertiSementConfigData : (xw4) invokeV.objValue;
    }

    public Integer getAnimAvgFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (oi.isEmpty(str)) {
                return 0;
            }
            yt4 k = yt4.k();
            return Integer.valueOf(k.l(str + "_anim_benchmark_avg_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public Integer getAnimAvgFpsCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (oi.isEmpty(str)) {
                return 0;
            }
            yt4 k = yt4.k();
            return Integer.valueOf(k.l(str + "_anim_benchmark_times_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public int getAnimComputedFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (oi.isEmpty(str)) {
                return -1;
            }
            return yt4.k().l(str, -1);
        }
        return invokeL.intValue;
    }

    public int getAnimFpsSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mAnimFpsSyncThreshold : invokeV.intValue;
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
                this.baiduIdForAnti = yt4.k().q("key_baiduid_for_anti", null);
            }
            return this.baiduIdForAnti;
        }
        return (String) invokeV.objValue;
    }

    public boolean getBaiduidCookieSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.isBaiduidCookieSwitch : invokeV.booleanValue;
    }

    public String getBannerText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mBannerText : (String) invokeV.objValue;
    }

    public vy4 getChannelConfigModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mChannelConfigModel : (vy4) invokeV.objValue;
    }

    public boolean getClipboardDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mClipboardDelayTime : invokeV.booleanValue;
    }

    public HashMap<String, h05> getColourHeaderConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mColourHeaderConfigs : (HashMap) invokeV.objValue;
    }

    public int getCpuFlopsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.mCpuFlopsDur < 0) {
                this.mCpuFlopsDur = yt4.k().l("cpu_flops_dura", 0);
            }
            return this.mCpuFlopsDur;
        }
        return invokeV.intValue;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mCpuThreshold : invokeV.intValue;
    }

    public long getCurrentClickTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.currentClickTime : invokeV.longValue;
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

    public long getDuXiaoManActivityTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.duXiaoManActivityTimestamp == 0) {
                this.duXiaoManActivityTimestamp = yt4.k().m("key_doxiaoman_activity_timestamp", 0L);
            }
            return this.duXiaoManActivityTimestamp;
        }
        return invokeV.longValue;
    }

    public boolean getExceptInsertAdDiaShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.isExceptInsertAdDiaShow : invokeV.booleanValue;
    }

    public Uri getFirstOpenScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.firstOpenScheme : (Uri) invokeV.objValue;
    }

    public boolean getForceRefreshHomeRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mForceRefreshHomeRecommend : invokeV.booleanValue;
    }

    public String getFromWhichSearchSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.fromWhichSearchSource : (String) invokeV.objValue;
    }

    public int getFrsCurTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mFrsCurTabType : invokeV.intValue;
    }

    public ww4 getHomeAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            vw4 vw4Var = this.adFloatViewData;
            if (vw4Var != null) {
                return vw4Var.a();
            }
            return null;
        }
        return (ww4) invokeV.objValue;
    }

    public ox4 getHomeInsertAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mHomeInsertAdData : (ox4) invokeV.objValue;
    }

    public k05 getHomeOperateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mHomeOperateData : (k05) invokeV.objValue;
    }

    public List<l05> getHomePageLuckyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mHomePageLuckyConfigs : (List) invokeV.objValue;
    }

    public int getHomePageStyleAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mHomePageStyleAbTest : invokeV.intValue;
    }

    public px4 getHomepageInterestConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.homepageInterestConfigData : (px4) invokeV.objValue;
    }

    public List<String> getHostWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mHostWhiteList : (List) invokeV.objValue;
    }

    public String getHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mHotSearch : (String) invokeV.objValue;
    }

    public String getInvokeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.invokeSource : (String) invokeV.objValue;
    }

    public Boolean getIsJumpFromVideoMiddleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? Boolean.valueOf(this.mIsJumpFromVideoMiddleView) : (Boolean) invokeV.objValue;
    }

    public boolean getIsNeedRemindLiveRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mIsNeedRemindLiveRoom : invokeV.booleanValue;
    }

    public boolean getIsNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mIsInNeedReuseVideoPlayer : invokeV.booleanValue;
    }

    public boolean getIsNeedShowPbCommentFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mIsNeedShowCommentFloat : invokeV.booleanValue;
    }

    public boolean getIsOutNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mIsOutNeedReuseVideoPlayer : invokeV.booleanValue;
    }

    public String getLFUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mLFUser : (String) invokeV.objValue;
    }

    public String getLFUserTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mLFUserTaskId : (String) invokeV.objValue;
    }

    public long getLastResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.lastResumeTime == 0) {
                this.lastResumeTime = yt4.k().m("last_resume_time", 0L);
            }
            return this.lastResumeTime;
        }
        return invokeV.longValue;
    }

    public MercatorModel.MercatorData getMercatorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mMercatorData : (MercatorModel.MercatorData) invokeV.objValue;
    }

    public String getMissionEntranceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mMissionEntranceIcon : (String) invokeV.objValue;
    }

    public String getMissionEntranceObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mMissionEntranceObjSource : (String) invokeV.objValue;
    }

    public String getMissionEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mMissionEntranceUrl : (String) invokeV.objValue;
    }

    public String getModName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            t88 t88Var = this.mUploadAndClearModule;
            if (t88Var == null) {
                return null;
            }
            return t88Var.a();
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.mNewGodData : (NewGodData) invokeV.objValue;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mNewUserRedPackageData : (NewUserRedPackageData) invokeV.objValue;
    }

    public ww4 getPbAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            vw4 vw4Var = this.adFloatViewData;
            if (vw4Var != null) {
                return vw4Var.b();
            }
            return null;
        }
        return (ww4) invokeV.objValue;
    }

    public up4 getPbToHomeUpdateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.mPbToHomeUpdateData : (up4) invokeV.objValue;
    }

    public t68 getPcdnConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.mPcdnConfigData : (t68) invokeV.objValue;
    }

    public int getPersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? yt4.k().l("key_personalized_rec_switch", 1) : invokeV.intValue;
    }

    public String getProfileGameCenterKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mProfileGameCenterKey : (String) invokeV.objValue;
    }

    @Modify(description = "配置预览机pub_env参数，1强制访问线上沙盒环境，2强制访问小流量环境", type = 1)
    public String getPubEnvValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.mPubEnvValue : (String) invokeV.objValue;
    }

    public long getPushDialogLoopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.pushDialogLoopTime : invokeV.longValue;
    }

    public long getPushDialogShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.pushDialogShowTime : invokeV.longValue;
    }

    public zx4 getPushStrategyConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            zx4 zx4Var = this.pushStrategyConfig;
            return zx4Var != null ? zx4Var : zx4.d;
        }
        return (zx4) invokeV.objValue;
    }

    public Bundle getReloginVideoMiddleBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.reloginVideoMiddleBundle : (Bundle) invokeV.objValue;
    }

    public String getSampleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mSampleId : (String) invokeV.objValue;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.schemaForStartOtherAppAfterSwanApp : (String) invokeV.objValue;
    }

    public by4 getShakeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.mShakeData : (by4) invokeV.objValue;
    }

    public cy4 getSharePanelConfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mSharePanelConfData : (cy4) invokeV.objValue;
    }

    public String getSharePanelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mSharePanelText : (String) invokeV.objValue;
    }

    public boolean getShowedInterestGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.showedInterestGuide : invokeV.booleanValue;
    }

    public yy4 getSyncModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.syncModel : (yy4) invokeV.objValue;
    }

    public boolean getSyncYYSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (this.isYYLive == null) {
                yt4 k = yt4.k();
                this.isYYLive = Boolean.valueOf(k.h("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
            }
            return this.isYYLive.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String getTempString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, str)) == null) ? this.tempStrings.get(str) : (String) invokeL.objValue;
    }

    public TiebaPlusConfigData getTiebaPlusConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mTiebaPlusConfigData : (TiebaPlusConfigData) invokeV.objValue;
    }

    public JSONArray getUbsABTestJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.mUbsABTestJsonArray : (JSONArray) invokeV.objValue;
    }

    public ey4 getUpgradePopWindowConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            ey4 ey4Var = this.upgradePopWindowConfig;
            return ey4Var != null ? ey4Var : ey4.i;
        }
        return (ey4) invokeV.objValue;
    }

    public RedIcon getVideoChannelAttentionRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.videoChannelAttentionRedIcon : (RedIcon) invokeV.objValue;
    }

    public RedIcon getVideoChannelRecommendRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.videoChannelRecommendRedIcon : (RedIcon) invokeV.objValue;
    }

    public Bitmap getVideoCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.mVideoCurrentFrame : (Bitmap) invokeV.objValue;
    }

    public hy4 getVideoEventsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.videoEventsConfig : (hy4) invokeV.objValue;
    }

    public LinkedList<hl4> getVideoRecordList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.mVideoWatchTimeRecord : (LinkedList) invokeV.objValue;
    }

    public int getVideoRedIconInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.videoRedIconInterval : invokeV.intValue;
    }

    public String getVideoTestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.videoTestType : (String) invokeV.objValue;
    }

    @NonNull
    public iy4 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            iy4 iy4Var = this.voiceRoomConfig;
            return iy4Var != null ? iy4Var : iy4.b;
        }
        return (iy4) invokeV.objValue;
    }

    public String getWalletSignLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.mWalletSignLink : (String) invokeV.objValue;
    }

    public ky4 getWlConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.mWlConfigData : (ky4) invokeV.objValue;
    }

    public int getWorksAddTopicMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.worksAddTopicMaxNum : invokeV.intValue;
    }

    public YYLiveConfig getYYLiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.mYYLiveConfig : (YYLiveConfig) invokeV.objValue;
    }

    public m09 getYYLiveTabConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.mYYLiveTabConfig : (m09) invokeV.objValue;
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mHasAgreeToPlay : invokeV.booleanValue;
    }

    public boolean hasDownloadEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.hasDownloadEmotion : invokeV.booleanValue;
    }

    public boolean hasPerformedFirstLoginTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.hasPerformedFirstLoginTest : invokeV.booleanValue;
    }

    public boolean interestGuideShowCountInLimit(String str, tx4 tx4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048669, this, str, tx4Var)) == null) {
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
                if (i > tx4Var.c) {
                    return i2 < tx4Var.d;
                } else if (i2 >= tx4Var.d - 1) {
                    return false;
                } else {
                    i2++;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isAnimEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, str)) == null) {
            if (isEnableBenchmark()) {
                if (getCpuFlopsDuration() > getCpuFlopsDurationSyncThreshold()) {
                    return false;
                }
                return !isAnimFpsComputed(str) || getAnimComputedFps(str) >= getAnimFpsSyncThreshold();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean isAnimFpsComputed(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, str)) == null) ? !oi.isEmpty(str) && getAnimComputedFps(str) >= 0 : invokeL.booleanValue;
    }

    public boolean isAuditPackageSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.mIsAuditPackageSwitchOn : invokeV.booleanValue;
    }

    public boolean isBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.browseMode : invokeV.booleanValue;
    }

    public boolean isBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.isBusinessAccount : invokeV.booleanValue;
    }

    public boolean isCanWebViewActivityShowProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.mCanWebViewActivityShowProgress : invokeV.booleanValue;
    }

    public boolean isClearOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            t88 t88Var = this.mUploadAndClearModule;
            if (t88Var == null) {
                return false;
            }
            return t88Var.b();
        }
        return invokeV.booleanValue;
    }

    public boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048677, this, activity)) == null) {
            if (this.mIsCutoutScreen < 0) {
                this.mIsCutoutScreen = UtilHelper.isCutoutScreen(activity) ? 1 : 0;
            }
            return this.mIsCutoutScreen == 1;
        }
        return invokeL.booleanValue;
    }

    public boolean isDanmuSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.isDanmuSwitchOpen : invokeV.booleanValue;
    }

    public boolean isDebugToolMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableBenchmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mEnableBenchmark : invokeV.booleanValue;
    }

    public boolean isEnableVideoVerticalPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.enableVideoVerticalPreload : invokeV.booleanValue;
    }

    public boolean isFlutterPluginLoadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.mIsFlutterPluginLoadSuccess : invokeV.booleanValue;
    }

    public boolean isFromFeedVideoClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.mIsFromFeedVideoClick : invokeV.booleanValue;
    }

    public boolean isFrsLoadingViewHided() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? (this.mFrsRootViewLoadingShow || this.mFrsContentViewLoadingShow) ? false : true : invokeV.booleanValue;
    }

    public boolean isIsOpenTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.mIsOpenTrack : invokeV.booleanValue;
    }

    public boolean isMercatorRequestFromHomePageTabFeedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.isMercatorRequestFromHomePageTabFeedFragment : invokeV.booleanValue;
    }

    public boolean isNeedShowInterestGuide() {
        InterceptResult invokeV;
        long j;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048687, this)) != null) {
            return invokeV.booleanValue;
        }
        tx4 interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
        if (interestBoardConfigData == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long m = yt4.k().m("key_new_user_logon_time", 0L);
        long m2 = yt4.k().m("key_home_recommend_item_click_time", 0L);
        long m3 = yt4.k().m("key_select_interest_flag", 0L);
        long m4 = yt4.k().m("key_app_launch_time", 0L);
        String q = yt4.k().q("key_interest_guide_show", "");
        boolean isSameDay = TimeHelper.isSameDay(System.currentTimeMillis() - (interestBoardConfigData.a * 86400000), m);
        boolean isTargetTimeInTimeBlock = TimeHelper.isTargetTimeInTimeBlock(m2, m, System.currentTimeMillis());
        int i = (int) (((((currentTimeMillis - m4) / 1000) / 60) / 60) / 24);
        if (!isSameDay || isTargetTimeInTimeBlock) {
            j = 0;
        } else {
            j = 0;
            if (m3 == 0) {
                z = true;
                if (m4 != j || i < interestBoardConfigData.b) {
                    z2 = false;
                } else {
                    this.triggerInterestPanelYDaysConfig = true;
                    z2 = true;
                }
                return (!z || z2) && interestGuideShowCountInLimit(q, interestBoardConfigData) && !getShowedInterestGuide();
            }
        }
        z = false;
        if (m4 != j) {
        }
        z2 = false;
        if (z) {
        }
    }

    public boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.isNewUser : invokeV.booleanValue;
    }

    public boolean isNewUserRedPackageShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.isNewUserRedPackageShowed : invokeV.booleanValue;
    }

    public boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048690, this, activity)) == null) {
            if (this.mIsNotchScreen < 0) {
                this.mIsNotchScreen = UtilHelper.isNotchScreen(activity) ? 1 : 0;
            }
            return this.mIsNotchScreen == 1;
        }
        return invokeL.booleanValue;
    }

    public boolean isPbPreloadSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1 : invokeV.booleanValue;
    }

    public boolean isRecommendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.isRecommendPage : invokeV.booleanValue;
    }

    public boolean isShouldShowHomeLocalCompleteInfoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.shouldShowHomeLocalCompleteInfoCard : invokeV.booleanValue;
    }

    public boolean isShowHomeFloatRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.mShowHomeFloatRefreshButton : invokeV.booleanValue;
    }

    public boolean isShowShoubaiDynamicGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.mShowShoubaiDynamicGuide : invokeV.booleanValue;
    }

    public boolean isShowStartLiveEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy") || !getSyncYYSwitch();
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVivoBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.mShowVivoBadge : invokeV.booleanValue;
    }

    public boolean isShowVoiceFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.mIsShowVoiceFloat : invokeV.booleanValue;
    }

    public boolean isSlideAnimEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            boolean z = yt4.k().l("slide_local_switch_is_clicked", 0) == 1;
            boolean z2 = yt4.k().l("sync_slide_animation__switch", 0) == 1;
            boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
            if (z) {
                return isSlideAnimLocalSwitchOn;
            }
            if (z2 != isSlideAnimLocalSwitchOn) {
                yt4.k().u("local_slide_animation__switch", z2);
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? yt4.k().h("local_slide_animation__switch", false) : invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.mTipsAutoPlayInVideoChannel : invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.mTipsAutoPlayInVideoMiddle : invokeV.booleanValue;
    }

    public boolean isUploadOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            t88 t88Var = this.mUploadAndClearModule;
            if (t88Var == null) {
                return false;
            }
            return t88Var.c();
        }
        return invokeV.booleanValue;
    }

    public boolean isUserBan() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.isUserBan : invokeV.booleanValue;
    }

    public boolean isVideoCardMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.mIsVideoCardMute : invokeV.booleanValue;
    }

    public boolean isVideoChannelRelogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.isVideoChannelRelogin : invokeV.booleanValue;
    }

    @Modify(description = "是否访问预览机", type = 1)
    public boolean isVisitPreviewServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.mIsVisitPreviewServer : invokeV.booleanValue;
    }

    public boolean isYYSwitchStatusIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy");
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadMoreLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? SwitchManager.getInstance().findType("need_more_logs") == 1 : invokeV.booleanValue;
    }

    public void onAccountChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            yt4 k = yt4.k();
            this.isYYLive = Boolean.valueOf(k.h("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
        }
    }

    public void putVideoRecord(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048711, this, str, i) == null) || oi.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        hl4 hl4Var = null;
        int i2 = size - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                break;
            }
            hl4 hl4Var2 = this.mVideoWatchTimeRecord.get(i3);
            if (!str.equals(hl4Var2.a())) {
                i3--;
            } else if (hl4Var2.b() == i) {
                return;
            } else {
                r1 = i3 == i2;
                hl4Var = hl4Var2;
            }
        }
        if (hl4Var != null) {
            hl4Var.c(i);
            if (r1) {
                return;
            }
            this.mVideoWatchTimeRecord.remove(hl4Var);
            this.mVideoWatchTimeRecord.addLast(hl4Var);
            return;
        }
        hl4 hl4Var3 = new hl4(str, i);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(hl4Var3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(hl4Var3);
    }

    public void recordAcceleratorServer(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048712, this, str, str2) == null) {
            this.mAcceleratorMap.put(str, str2);
        }
    }

    public void registerScreenSizeChangeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            qg.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.3
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
                                return (interceptable3 == null || (invokeL = interceptable3.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921414) : (CustomResponsedMessage) invokeL.objValue;
                            }
                        });
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                        MessageManager.getInstance().registerTask(customMessageTask);
                    }
                }
            });
        }
    }

    public void removeAcceleratorServer(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048714, this, str) == null) && this.mAcceleratorMap.containsKey(str)) {
            this.mAcceleratorMap.remove(str);
        }
    }

    public void removeTempString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, str) == null) {
            this.tempStrings.remove(str);
        }
    }

    public void saveHomeRecommendItemClickTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            yt4.k().x("key_home_recommend_item_click_time", System.currentTimeMillis());
        }
    }

    public void setActiveTimeStamp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048717, this) == null) && getActiveTimeStamp() == 0) {
            yt4.k().x("key_active_timestamp", System.currentTimeMillis());
        }
    }

    public void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048718, this, str) == null) {
            this.mActivityId = str;
        }
    }

    public void setAdFloatViewData(vw4 vw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048719, this, vw4Var) == null) {
            this.adFloatViewData = vw4Var;
        }
    }

    public void setAdVertiSementData(xw4 xw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048720, this, xw4Var) == null) {
            this.mAdVertiSementConfigData = xw4Var;
        }
    }

    public void setAnimAverageFpsThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i) == null) {
            this.mAnimFpsSyncThreshold = i;
            yt4.k().w("anim_avg_fps_threshold", i);
        }
    }

    public void setAnimAvgFps(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048722, this, str, i) == null) || oi.isEmpty(str) || i < 0) {
            return;
        }
        yt4 k = yt4.k();
        k.w(str + "_anim_benchmark_avg_suffix", i);
    }

    public void setAnimAvgFpsCount(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048723, this, str, i) == null) || oi.isEmpty(str) || i < 0) {
            return;
        }
        yt4 k = yt4.k();
        k.w(str + "_anim_benchmark_times_suffix", i);
    }

    public void setAnimComputedFps(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048724, this, str, i) == null) || oi.isEmpty(str)) {
            return;
        }
        yt4.k().w(str, i);
        if (!"anim_switch_slide".equals(str) || isAnimEnable(str)) {
            return;
        }
        setSlideAnimLocalSwitch(false);
    }

    public void setAuditPackageSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z) == null) {
            this.mIsAuditPackageSwitchOn = z;
        }
    }

    public void setBaiduIdForAnti(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048726, this, str) == null) && yt4.k().q("key_baiduid_for_anti", null) == null) {
            yt4.k().y("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBaiduidCookieSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i) == null) {
            this.isBaiduidCookieSwitch = i == 1;
        }
    }

    public void setBannerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, str) == null) {
            this.mBannerText = str;
        }
    }

    public void setBrowseMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            this.browseMode = z;
        }
    }

    public void setBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048731, this, z) == null) {
            this.isBusinessAccount = z;
        }
    }

    public void setCanShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z) == null) {
            this.canShowPermDlg = z;
        }
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048733, this, z) == null) {
            this.mCanWebViewActivityShowProgress = z;
        }
    }

    public void setChannelConfigModel(vy4 vy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, vy4Var) == null) {
            this.mChannelConfigModel = vy4Var;
        }
    }

    public void setClipboardDelayTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
            this.mClipboardDelayTime = z;
        }
    }

    public void setColourHeaderConfig(HashMap<String, h05> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, hashMap) == null) {
            this.mColourHeaderConfigs = hashMap;
        }
    }

    public void setCpuFlopsDuration(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048737, this, i) == null) || i < 0) {
            return;
        }
        this.mCpuFlopsDur = i;
        yt4.k().w("cpu_flops_dura", i);
    }

    public void setCpuThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048738, this, i) == null) {
            this.mCpuThreshold = i;
            yt4.k().w("cpu_flops_dura_threshold", i);
        }
    }

    public void setCurrentClickTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048739, this, j) == null) {
            this.currentClickTime = j;
        }
    }

    public void setDanmuSwitchOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
            this.isDanmuSwitchOpen = z;
            yt4.k().u("key_video_danmu_switch", z);
        }
    }

    public void setDuXiaoManActivityTimestamp(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048741, this, j) == null) || j == this.duXiaoManActivityTimestamp) {
            return;
        }
        this.duXiaoManActivityTimestamp = j;
        yt4.k().x("key_doxiaoman_activity_timestamp", j);
    }

    public void setEnableBenchmark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z) == null) {
            this.mEnableBenchmark = z;
            yt4.k().u("enable_benchmark", z);
        }
    }

    public void setEnableVideoVerticalPreload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048743, this, z) == null) {
            this.enableVideoVerticalPreload = z;
        }
    }

    public void setExceptInsertAdDiaShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z) == null) {
            this.isExceptInsertAdDiaShow = z;
        }
    }

    public void setFirstOpenScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048745, this, uri) == null) {
            this.firstOpenScheme = uri;
        }
    }

    public void setFlutterPluginLoadSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
            this.mIsFlutterPluginLoadSuccess = z;
        }
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
            this.mForceRefreshHomeRecommend = z;
        }
    }

    public void setFromFeedVideoClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z) == null) {
            this.mIsFromFeedVideoClick = z;
        }
    }

    public void setFromWhichSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, str) == null) {
            this.fromWhichSearchSource = str;
        }
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.mFrsContentViewLoadingShow = z;
        }
    }

    public void setFrsCurTabType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048751, this, i) == null) {
            this.mFrsCurTabType = i;
        }
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048752, this, z) == null) {
            this.mFrsRootViewLoadingShow = z;
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048753, this, z) == null) {
            this.mHasAgreeToPlay = z;
        }
    }

    public void setHasDownloadEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z) == null) {
            this.hasDownloadEmotion = z;
        }
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z) == null) {
            this.hasPerformedFirstLoginTest = z;
            yt4.k().u("has_performed_first_login_test", z);
        }
    }

    public void setHasShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z) == null) {
            this.hasShowPermDlg = z;
        }
    }

    public void setHomeInsertAdData(ox4 ox4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048757, this, ox4Var) == null) {
            this.mHomeInsertAdData = ox4Var;
        }
    }

    public void setHomeOperateData(k05 k05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, k05Var) == null) {
            this.mHomeOperateData = k05Var;
        }
    }

    public void setHomePageLuckyConfig(List<l05> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048759, this, list) == null) {
            this.mHomePageLuckyConfigs = list;
        }
    }

    public void setHomePageStyleAbTest(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048760, this, i) == null) {
            this.mHomePageStyleAbTest = i;
        }
    }

    public void setHomepageInterestConfig(px4 px4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, px4Var) == null) {
            this.homepageInterestConfigData = px4Var;
        }
    }

    public void setHostWhiteList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, list) == null) {
            this.mHostWhiteList = list;
        }
    }

    public void setHotSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, str) == null) {
            this.mHotSearch = str;
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, str) == null) {
            this.invokeSource = str;
        }
    }

    public void setIsJumpFromVideoMiddleView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048765, this, z) == null) {
            this.mIsJumpFromVideoMiddleView = z;
        }
    }

    public void setIsNeedRemindLiveRoom(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
            this.mIsNeedRemindLiveRoom = z;
        }
    }

    public void setIsNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048767, this, z) == null) {
            this.mIsInNeedReuseVideoPlayer = z;
        }
    }

    public void setIsNeedShowPbCommentFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048768, this, z) == null) {
            this.mIsNeedShowCommentFloat = z;
        }
    }

    public void setIsOpenTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048769, this, z) == null) {
            this.mIsOpenTrack = z;
        }
    }

    public void setIsOutNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048770, this, z) == null) {
            this.mIsOutNeedReuseVideoPlayer = z;
        }
    }

    public void setIsRecommendPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048771, this, z) == null) {
            this.isRecommendPage = z;
        }
    }

    public void setLFUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, str) == null) {
            this.mLFUser = str;
        }
    }

    public void setLFUserTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048773, this, str) == null) {
            this.mLFUserTaskId = str;
        }
    }

    public void setLastResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048774, this, j) == null) {
            this.lastResumeTime = j;
        }
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, hashMap) == null) {
            this.liveForumMap = hashMap;
        }
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, mercatorData) == null) {
            this.mMercatorData = mercatorData;
        }
    }

    public void setMercatorRequestFromHomePageTabFeedFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048777, this, z) == null) {
            this.isMercatorRequestFromHomePageTabFeedFragment = z;
        }
    }

    public void setMissionEntranceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048778, this, str) == null) {
            this.mMissionEntranceIcon = str;
        }
    }

    public void setMissionEntranceObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048779, this, str) == null) {
            this.mMissionEntranceObjSource = str;
        }
    }

    public void setMissionEntranceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, str) == null) {
            this.mMissionEntranceUrl = str;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setNewUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048782, this, z) == null) {
            this.isNewUser = z;
        }
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, newUserRedPackageData) == null) {
            this.mNewUserRedPackageData = newUserRedPackageData;
        }
    }

    public void setNewUserRedPackageShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048784, this, z) == null) {
            this.isNewUserRedPackageShowed = z;
            yt4.k().u("key_task_system_new_user_popup_show_number", z);
        }
    }

    public void setPbToHomeUpdateData(up4 up4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, up4Var) == null) {
            this.mPbToHomeUpdateData = up4Var;
        }
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048786, this, jSONObject) == null) {
            if (this.mPcdnConfigData == null) {
                this.mPcdnConfigData = new t68();
            }
            this.mPcdnConfigData.d(jSONObject);
        }
    }

    public void setProfileGameCenterKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048787, this, str) == null) {
            this.mProfileGameCenterKey = str;
        }
    }

    public void setPubEnvValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048788, this, str) == null) {
            this.mPubEnvValue = str;
        }
    }

    public void setPushDialogLoopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048789, this, j) == null) {
            this.pushDialogLoopTime = j;
        }
    }

    public void setPushDialogShowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048790, this, j) == null) {
            this.pushDialogShowTime = j;
        }
    }

    public void setPushStrategyConfig(zx4 zx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, zx4Var) == null) {
            this.pushStrategyConfig = zx4Var;
        }
    }

    public void setReloginVideoMiddleBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048792, this, bundle) == null) {
            this.reloginVideoMiddleBundle = bundle;
        }
    }

    public void setSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048793, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, str) == null) {
            this.schemaForStartOtherAppAfterSwanApp = str;
        }
    }

    public void setShakeData(by4 by4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048795, this, by4Var) == null) {
            this.mShakeData = by4Var;
        }
    }

    public void setSharePanelConfData(cy4 cy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048796, this, cy4Var) == null) {
            this.mSharePanelConfData = cy4Var;
        }
    }

    public void setSharePanelText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, str) == null) {
            this.mSharePanelText = str;
        }
    }

    public void setShouldShowHomeLocalCompleteInfoCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048798, this, z) == null) {
            this.shouldShowHomeLocalCompleteInfoCard = z;
        }
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048799, this, z) == null) {
            this.mShowShoubaiDynamicGuide = z;
        }
    }

    public void setShowVoiceFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048800, this, z) == null) {
            this.mIsShowVoiceFloat = z;
        }
    }

    public void setShowedInterestGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048801, this, z) == null) {
            this.showedInterestGuide = z;
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048802, this, z) == null) {
            yt4.k().u("local_slide_animation__switch", z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
        }
    }

    public void setSyncModel(yy4 yy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048803, this, yy4Var) == null) {
            this.syncModel = yy4Var;
        }
    }

    public void setSyncYYSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048804, this, z) == null) {
            this.isYYLive = Boolean.valueOf(z);
            yt4 k = yt4.k();
            k.u("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void setTempString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048805, this, str, str2) == null) {
            this.tempStrings.put(str, str2);
        }
    }

    public void setTiebaPlusConfigData(TiebaPlusConfigData tiebaPlusConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048806, this, tiebaPlusConfigData) == null) {
            this.mTiebaPlusConfigData = tiebaPlusConfigData;
        }
    }

    public void setTipsAutoPlayInVideoChannel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048807, this, z) == null) {
            this.mTipsAutoPlayInVideoChannel = z;
        }
    }

    public void setTipsAutoPlayInVideoMiddle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048808, this, z) == null) {
            this.mTipsAutoPlayInVideoMiddle = z;
        }
    }

    public void setUbsABTestJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048809, this, jSONArray) == null) {
            this.mUbsABTestJsonArray = jSONArray;
        }
    }

    public void setUpgradePopWindowConfig(ey4 ey4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, ey4Var) == null) {
            this.upgradePopWindowConfig = ey4Var;
        }
    }

    public void setUploadAndClearModule(t88 t88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, t88Var) == null) {
            this.mUploadAndClearModule = t88Var;
        }
    }

    public void setUserBan(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048812, this, z) == null) {
            this.isUserBan = z;
        }
    }

    public void setVideoCardMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048813, this, z) == null) {
            this.mIsVideoCardMute = z;
        }
    }

    public void setVideoChannelAttentionRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, redIcon) == null) {
            boolean z = (redIcon == null && this.videoChannelAttentionRedIcon == null) ? false : true;
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

    public void setVideoChannelRecommendRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, redIcon) == null) {
            if (!isFromFeedVideoClick()) {
                this.videoChannelRecommendRedIcon = redIcon;
            }
            if (redIcon != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, redIcon.text));
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921577, ""));
            }
        }
    }

    public void setVideoChannelRelogin(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048816, this, z) == null) {
            this.isVideoChannelRelogin = z;
        }
    }

    public void setVideoCurrentFrame(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048817, this, bitmap) == null) {
            this.mVideoCurrentFrame = bitmap;
        }
    }

    public void setVideoEventsConfig(hy4 hy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048818, this, hy4Var) == null) {
            hy4 hy4Var2 = this.videoEventsConfig;
            if (hy4Var2 == null) {
                this.videoEventsConfig = hy4Var;
            } else if (hy4Var2.a(hy4Var)) {
            } else {
                this.videoEventsConfig = hy4Var;
            }
        }
    }

    public void setVideoRedIconInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048819, this, i) == null) {
            this.videoRedIconInterval = i;
        }
    }

    public void setVideoTestType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048820, this, str) == null) {
            this.videoTestType = str;
        }
    }

    public void setVisitPreviewServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048821, this, z) == null) {
            this.mIsVisitPreviewServer = z;
        }
    }

    public void setVoiceRoomConfig(@Nullable iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048822, this, iy4Var) == null) {
            this.voiceRoomConfig = iy4Var;
        }
    }

    public void setWalletSignLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048823, this, str) == null) {
            this.mWalletSignLink = str;
        }
    }

    public void setWlConfigData(ky4 ky4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048824, this, ky4Var) == null) {
            this.mWlConfigData = ky4Var;
        }
    }

    public void setWorksAddTopicMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048825, this, i) == null) {
            this.worksAddTopicMaxNum = i;
        }
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048826, this, yYLiveConfig) == null) {
            this.mYYLiveConfig = yYLiveConfig;
        }
    }

    public void setYYLiveTabConfig(m09 m09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048827, this, m09Var) == null) {
            this.mYYLiveTabConfig = m09Var;
        }
    }

    public void setYyCloudSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048828, this, str) == null) {
            this.yyCloudSwitch = str;
            yt4.k().y("key_yy_cloud_switch", str);
        }
    }

    public void startOneGame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048829, this) == null) && this.mStartGameClicked) {
            this.mStartGameClicked = false;
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", "15471320").param("obj_source", "game_lauch_screen").param("obj_name", "可口大冒险").param("obj_param1", 1));
        }
    }

    @NonNull
    public String getAdVertiComment(boolean z, boolean z2, @NonNull String str) {
        InterceptResult invokeCommon;
        String adStrWithLimit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z) {
                adStrWithLimit = getAdStrWithLimit();
                if (StringUtils.isNull(adStrWithLimit)) {
                    return str;
                }
            } else if (!z2) {
                return str;
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

    public void setBaiduidCookieSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048728, this, z) == null) {
            this.isBaiduidCookieSwitch = z;
        }
    }
}
