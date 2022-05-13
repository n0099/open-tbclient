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
import com.baidu.tbadk.abtest.group.ImRecForumShowABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
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
import com.repackage.ay4;
import com.repackage.c29;
import com.repackage.cy4;
import com.repackage.fq4;
import com.repackage.fy4;
import com.repackage.gy4;
import com.repackage.iu4;
import com.repackage.iy4;
import com.repackage.k98;
import com.repackage.li;
import com.repackage.n78;
import com.repackage.ng;
import com.repackage.ox4;
import com.repackage.px4;
import com.repackage.qy4;
import com.repackage.tx4;
import com.repackage.ty4;
import com.repackage.ul4;
import com.repackage.ww4;
import com.repackage.xw4;
import com.repackage.yw4;
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
    public String accountWhenColdStart;
    public long activeTimeStamp;
    public ww4 adFloatViewData;
    public long appFirstInstallTime;
    public long appLastUpdateTime;
    public String baiduIdForAnti;
    public boolean browseMode;
    public Calendar calendar;
    public boolean canShowPermDlg;
    public long currentClickTime;
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
    public boolean isVideoChannelRelogin;
    public Boolean isYYLive;
    public long lastResumeTime;
    public HashMap<Long, String> liveForumMap;
    public final HashMap<String, String> mAcceleratorMap;
    public String mActivityId;
    public yw4 mAdVertiSementConfigData;
    public int mAnimFpsSyncThreshold;
    public String mBannerText;
    public final String mBaseActivity;
    public final String mBaseFragmentActivity;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public boolean mCanWebViewActivityShowProgress;
    public qy4 mChannelConfigModel;
    public boolean mClipboardDelayTime;
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
    public int mHomePageStyleAbTest;
    public List<String> mHostWhiteList;
    public String mHotSearch;
    public boolean mIsAuditPackageSwitchOn;
    public int mIsCutoutScreen;
    public boolean mIsFlutterPluginLoadSuccess;
    public boolean mIsFromFeedVideoClick;
    public boolean mIsInNeedReuseVideoPlayer;
    public boolean mIsJumpFromVideoMiddleView;
    public boolean mIsNeedShowCommentFloat;
    public int mIsNotchScreen;
    public boolean mIsOpenTrack;
    public boolean mIsOutNeedReuseVideoPlayer;
    public boolean mIsShowVoiceFloat;
    public boolean mIsVideoCardMute;
    public boolean mIsVisitPreviewServer;
    public String mLFUser;
    public String mLFUserTaskId;
    public MercatorModel.MercatorData mMercatorData;
    public String mMissionEntranceIcon;
    public String mMissionEntranceObjSource;
    public String mMissionEntranceUrl;
    public NewGodData mNewGodData;
    public NewUserRedPackageData mNewUserRedPackageData;
    public fq4 mPbToHomeUpdateData;
    public n78 mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public String mSampleId;
    public zx4 mShakeData;
    public ay4 mSharePanelConfData;
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
    public k98 mUploadAndClearModule;
    public Bitmap mVideoCurrentFrame;
    public LinkedList<ul4> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public iy4 mWlConfigData;
    public YYLiveConfig mYYLiveConfig;
    public c29 mYYLiveTabConfig;
    public boolean needRefreshForumSquare;
    public boolean personalizedRecSwitchChanged;
    public long pushDialogLoopTime;
    public long pushDialogShowTime;
    public Bundle reloginVideoMiddleBundle;
    public String schemaForStartOtherAppAfterSwanApp;
    public boolean shouldShowHomeLocalCompleteInfoCard;
    public boolean shouldShowLocalChannelPostAnim;
    public boolean showStampMissionDialog;
    public boolean showedInterestGuide;
    public ty4 syncModel;
    public HashMap<String, String> tempStrings;
    public boolean triggerInterestPanelYDaysConfig;
    public cy4 upgradePopWindowConfig;
    public RedIcon videoChannelAttentionRedIcon;
    public RedIcon videoChannelRecommendRedIcon;
    public fy4 videoEventsConfig;
    public int videoRedIconInterval;
    public String videoTestType;
    @Nullable
    public gy4 voiceRoomConfig;
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
        this.THREE_DAY_MILLISECOND = 259200000L;
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
        this.mBaseActivity = "BaseActivity";
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
        this.accountWhenColdStart = null;
        this.isCanShowHotSplash = false;
        this.triggerInterestPanelYDaysConfig = false;
        this.hasPerformInterestPanelShow = false;
        this.tempStrings = new HashMap<>();
        this.isBaiduidCookieSwitch = false;
        this.mIsFlutterPluginLoadSuccess = false;
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
        setIsOpenTrack(iu4.k().h("key_is_open_track", false));
        setProfileGameCenterKey(iu4.k().q("profile_swan_app_key", ""));
        setHomePageStyleAbTest(iu4.k().l("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(iu4.k().q("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(iu4.k().q("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(iu4.k().q("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(iu4.k().h("audit_package_switch", false));
        setBaiduidCookieSwitch(iu4.k().h("key_baidu_id_cookie_switch", false));
        setUbsSampleId(iu4.k().q("key_ubs_sample_id", ""));
        setShowShoubaiDynamicGuide(iu4.k().l("key_is_show_shoubai_dynamic_guide", 0) == 1);
        this.mShowHomeFloatRefreshButton = iu4.k().l("key_home_refresh_button_test", 0) == 1;
        setClipboardDelayTime(iu4.k().h("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        setDanmuSwitchOpen(iu4.k().h("key_video_danmu_switch", true));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        ng.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.1
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
        this.mShowVivoBadge = iu4.k().h("key_show_vivo_badge", false);
        this.mChannelConfigModel = new qy4();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = iu4.k().h("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = iu4.k().h("has_performed_first_login_test", false);
        this.yyCloudSwitch = iu4.k().q("key_yy_cloud_switch", null);
        this.isStartStatUploadImmediately = iu4.k().l("key_switch_immediately_upload", 0) == 1;
    }

    private String getAdStrWithLimit() {
        InterceptResult invokeV;
        yw4 yw4Var;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (StringHelper.isTaday(iu4.k().m("key_pb_falling_ad_feedback_click_time", 0L)) || (yw4Var = this.mAdVertiSementConfigData) == null) ? "" : yw4Var.c() : (String) invokeV.objValue;
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
            this.mEnableBenchmark = iu4.k().h("enable_benchmark", true);
            this.mCpuThreshold = iu4.k().l("cpu_flops_dura_threshold", Integer.MAX_VALUE);
            this.mAnimFpsSyncThreshold = iu4.k().l("anim_avg_fps_threshold", 0);
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
            return this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - iu4.k().m("key_first_enter_app_timestamp", 0L) > 259200000;
        }
        return invokeV.booleanValue;
    }

    public boolean checkLiveForumByFid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j))) : invokeJ.booleanValue;
    }

    public void clearVideoRecord() {
        LinkedList<ul4> linkedList;
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
                this.activeTimeStamp = iu4.k().m("key_active_timestamp", 0L);
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

    public yw4 getAdVertiSementData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdVertiSementConfigData : (yw4) invokeV.objValue;
    }

    public Integer getAnimAvgFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (li.isEmpty(str)) {
                return 0;
            }
            iu4 k = iu4.k();
            return Integer.valueOf(k.l(str + "_anim_benchmark_avg_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public Integer getAnimAvgFpsCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (li.isEmpty(str)) {
                return 0;
            }
            iu4 k = iu4.k();
            return Integer.valueOf(k.l(str + "_anim_benchmark_times_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public int getAnimComputedFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (li.isEmpty(str)) {
                return -1;
            }
            return iu4.k().l(str, -1);
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
                this.baiduIdForAnti = iu4.k().q("key_baiduid_for_anti", null);
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

    public qy4 getChannelConfigModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mChannelConfigModel : (qy4) invokeV.objValue;
    }

    public boolean getClipboardDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mClipboardDelayTime : invokeV.booleanValue;
    }

    public int getCpuFlopsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.mCpuFlopsDur < 0) {
                this.mCpuFlopsDur = iu4.k().l("cpu_flops_dura", 0);
            }
            return this.mCpuFlopsDur;
        }
        return invokeV.intValue;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mCpuThreshold : invokeV.intValue;
    }

    public long getCurrentClickTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.currentClickTime : invokeV.longValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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

    public boolean getExceptInsertAdDiaShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.isExceptInsertAdDiaShow : invokeV.booleanValue;
    }

    public Uri getFirstOpenScheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.firstOpenScheme : (Uri) invokeV.objValue;
    }

    public boolean getForceRefreshHomeRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mForceRefreshHomeRecommend : invokeV.booleanValue;
    }

    public String getFromWhichSearchSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.fromWhichSearchSource : (String) invokeV.objValue;
    }

    public int getFrsCurTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mFrsCurTabType : invokeV.intValue;
    }

    public xw4 getHomeAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ww4 ww4Var = this.adFloatViewData;
            if (ww4Var != null) {
                return ww4Var.a();
            }
            return null;
        }
        return (xw4) invokeV.objValue;
    }

    public ox4 getHomeInsertAdData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mHomeInsertAdData : (ox4) invokeV.objValue;
    }

    public int getHomePageStyleAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mHomePageStyleAbTest : invokeV.intValue;
    }

    public px4 getHomepageInterestConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.homepageInterestConfigData : (px4) invokeV.objValue;
    }

    public List<String> getHostWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mHostWhiteList : (List) invokeV.objValue;
    }

    public String getHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mHotSearch : (String) invokeV.objValue;
    }

    public String getInvokeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.invokeSource : (String) invokeV.objValue;
    }

    public Boolean getIsJumpFromVideoMiddleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? Boolean.valueOf(this.mIsJumpFromVideoMiddleView) : (Boolean) invokeV.objValue;
    }

    public boolean getIsNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.mIsInNeedReuseVideoPlayer : invokeV.booleanValue;
    }

    public boolean getIsNeedShowPbCommentFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mIsNeedShowCommentFloat : invokeV.booleanValue;
    }

    public boolean getIsOutNeedReuseVideoPlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mIsOutNeedReuseVideoPlayer : invokeV.booleanValue;
    }

    public String getLFUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mLFUser : (String) invokeV.objValue;
    }

    public String getLFUserTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mLFUserTaskId : (String) invokeV.objValue;
    }

    public long getLastResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.lastResumeTime == 0) {
                this.lastResumeTime = iu4.k().m("last_resume_time", 0L);
            }
            return this.lastResumeTime;
        }
        return invokeV.longValue;
    }

    public MercatorModel.MercatorData getMercatorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mMercatorData : (MercatorModel.MercatorData) invokeV.objValue;
    }

    public String getMissionEntranceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.mMissionEntranceIcon : (String) invokeV.objValue;
    }

    public String getMissionEntranceObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.mMissionEntranceObjSource : (String) invokeV.objValue;
    }

    public String getMissionEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mMissionEntranceUrl : (String) invokeV.objValue;
    }

    public String getModName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            k98 k98Var = this.mUploadAndClearModule;
            if (k98Var == null) {
                return null;
            }
            return k98Var.a();
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mNewGodData : (NewGodData) invokeV.objValue;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mNewUserRedPackageData : (NewUserRedPackageData) invokeV.objValue;
    }

    public xw4 getPbAdFloatViewItemData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            ww4 ww4Var = this.adFloatViewData;
            if (ww4Var != null) {
                return ww4Var.b();
            }
            return null;
        }
        return (xw4) invokeV.objValue;
    }

    public fq4 getPbToHomeUpdateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.mPbToHomeUpdateData : (fq4) invokeV.objValue;
    }

    public n78 getPcdnConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.mPcdnConfigData : (n78) invokeV.objValue;
    }

    public int getPersonalizedRecSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? iu4.k().l("key_personalized_rec_switch", 1) : invokeV.intValue;
    }

    public String getProfileGameCenterKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mProfileGameCenterKey : (String) invokeV.objValue;
    }

    @Modify(description = "配置预览机pub_env参数，1强制访问线上沙盒环境，2强制访问小流量环境", type = 1)
    public String getPubEnvValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mPubEnvValue : (String) invokeV.objValue;
    }

    public long getPushDialogLoopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.pushDialogLoopTime : invokeV.longValue;
    }

    public long getPushDialogShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.pushDialogShowTime : invokeV.longValue;
    }

    public Bundle getReloginVideoMiddleBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.reloginVideoMiddleBundle : (Bundle) invokeV.objValue;
    }

    public String getSampleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.mSampleId : (String) invokeV.objValue;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.schemaForStartOtherAppAfterSwanApp : (String) invokeV.objValue;
    }

    public zx4 getShakeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mShakeData : (zx4) invokeV.objValue;
    }

    public ay4 getSharePanelConfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.mSharePanelConfData : (ay4) invokeV.objValue;
    }

    public String getSharePanelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mSharePanelText : (String) invokeV.objValue;
    }

    public boolean getShowedInterestGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.showedInterestGuide : invokeV.booleanValue;
    }

    public ty4 getSyncModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.syncModel : (ty4) invokeV.objValue;
    }

    public boolean getSyncYYSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (this.isYYLive == null) {
                iu4 k = iu4.k();
                this.isYYLive = Boolean.valueOf(k.h("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
            }
            return this.isYYLive.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public String getTempString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, str)) == null) ? this.tempStrings.get(str) : (String) invokeL.objValue;
    }

    public TiebaPlusConfigData getTiebaPlusConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.mTiebaPlusConfigData : (TiebaPlusConfigData) invokeV.objValue;
    }

    public JSONArray getUbsABTestJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.mUbsABTestJsonArray : (JSONArray) invokeV.objValue;
    }

    public cy4 getUpgradePopWindowConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            cy4 cy4Var = this.upgradePopWindowConfig;
            return cy4Var != null ? cy4Var : cy4.i;
        }
        return (cy4) invokeV.objValue;
    }

    public RedIcon getVideoChannelAttentionRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.videoChannelAttentionRedIcon : (RedIcon) invokeV.objValue;
    }

    public RedIcon getVideoChannelRecommendRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.videoChannelRecommendRedIcon : (RedIcon) invokeV.objValue;
    }

    public Bitmap getVideoCurrentFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.mVideoCurrentFrame : (Bitmap) invokeV.objValue;
    }

    public fy4 getVideoEventsConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.videoEventsConfig : (fy4) invokeV.objValue;
    }

    public LinkedList<ul4> getVideoRecordList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.mVideoWatchTimeRecord : (LinkedList) invokeV.objValue;
    }

    public int getVideoRedIconInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.videoRedIconInterval : invokeV.intValue;
    }

    public String getVideoTestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.videoTestType : (String) invokeV.objValue;
    }

    @NonNull
    public gy4 getVoiceRoomConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            gy4 gy4Var = this.voiceRoomConfig;
            return gy4Var != null ? gy4Var : gy4.b;
        }
        return (gy4) invokeV.objValue;
    }

    public String getWalletSignLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.mWalletSignLink : (String) invokeV.objValue;
    }

    public iy4 getWlConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mWlConfigData : (iy4) invokeV.objValue;
    }

    public int getWorksAddTopicMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.worksAddTopicMaxNum : invokeV.intValue;
    }

    public YYLiveConfig getYYLiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.mYYLiveConfig : (YYLiveConfig) invokeV.objValue;
    }

    public c29 getYYLiveTabConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mYYLiveTabConfig : (c29) invokeV.objValue;
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.mHasAgreeToPlay : invokeV.booleanValue;
    }

    public boolean hasDownloadEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.hasDownloadEmotion : invokeV.booleanValue;
    }

    public boolean hasPerformedFirstLoginTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.hasPerformedFirstLoginTest : invokeV.booleanValue;
    }

    public boolean interestGuideShowCountInLimit(String str, tx4 tx4Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048663, this, str, tx4Var)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, str)) == null) ? !li.isEmpty(str) && getAnimComputedFps(str) >= 0 : invokeL.booleanValue;
    }

    public boolean isAuditPackageSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mIsAuditPackageSwitchOn : invokeV.booleanValue;
    }

    public boolean isBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.browseMode : invokeV.booleanValue;
    }

    public boolean isBusinessAccount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.isBusinessAccount : invokeV.booleanValue;
    }

    public boolean isCanWebViewActivityShowProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.mCanWebViewActivityShowProgress : invokeV.booleanValue;
    }

    public boolean isClearOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            k98 k98Var = this.mUploadAndClearModule;
            if (k98Var == null) {
                return false;
            }
            return k98Var.b();
        }
        return invokeV.booleanValue;
    }

    public boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048671, this, activity)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.isDanmuSwitchOpen : invokeV.booleanValue;
    }

    public boolean isDebugToolMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableBenchmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.mEnableBenchmark : invokeV.booleanValue;
    }

    public boolean isEnableVideoVerticalPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.enableVideoVerticalPreload : invokeV.booleanValue;
    }

    public boolean isFlutterPluginLoadSuccess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.mIsFlutterPluginLoadSuccess : invokeV.booleanValue;
    }

    public boolean isFromFeedVideoClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.mIsFromFeedVideoClick : invokeV.booleanValue;
    }

    public boolean isFrsLoadingViewHided() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? (this.mFrsRootViewLoadingShow || this.mFrsContentViewLoadingShow) ? false : true : invokeV.booleanValue;
    }

    public boolean isImRecForumShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (getUbsABTestJsonArray() == null) {
                return false;
            }
            for (int i = 0; i < getUbsABTestJsonArray().length(); i++) {
                try {
                    JSONObject jSONObject = getUbsABTestJsonArray().getJSONObject(i);
                    if (jSONObject != null && ImRecForumShowABTest.TYPE_A.equals(jSONObject.optString("sid"))) {
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIsOpenTrack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mIsOpenTrack : invokeV.booleanValue;
    }

    public boolean isMercatorRequestFromHomePageTabFeedFragment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) ? this.isMercatorRequestFromHomePageTabFeedFragment : invokeV.booleanValue;
    }

    public boolean isNeedShowInterestGuide() {
        InterceptResult invokeV;
        long j;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048682, this)) != null) {
            return invokeV.booleanValue;
        }
        tx4 interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
        if (interestBoardConfigData == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long m = iu4.k().m("key_new_user_logon_time", 0L);
        long m2 = iu4.k().m("key_home_recommend_item_click_time", 0L);
        long m3 = iu4.k().m("key_select_interest_flag", 0L);
        long m4 = iu4.k().m("key_app_launch_time", 0L);
        String q = iu4.k().q("key_interest_guide_show", "");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.isNewUser : invokeV.booleanValue;
    }

    public boolean isNewUserRedPackageShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.isNewUserRedPackageShowed : invokeV.booleanValue;
    }

    public boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, activity)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1 : invokeV.booleanValue;
    }

    public boolean isRecommendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.isRecommendPage : invokeV.booleanValue;
    }

    public boolean isShouldShowHomeLocalCompleteInfoCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.shouldShowHomeLocalCompleteInfoCard : invokeV.booleanValue;
    }

    public boolean isShowHomeFloatRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.mShowHomeFloatRefreshButton : invokeV.booleanValue;
    }

    public boolean isShowShoubaiDynamicGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.mShowShoubaiDynamicGuide : invokeV.booleanValue;
    }

    public boolean isShowStartLiveEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy") || !getSyncYYSwitch();
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVivoBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.mShowVivoBadge : invokeV.booleanValue;
    }

    public boolean isShowVoiceFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.mIsShowVoiceFloat : invokeV.booleanValue;
    }

    public boolean isSlideAnimEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            boolean z = iu4.k().l("slide_local_switch_is_clicked", 0) == 1;
            boolean z2 = iu4.k().l("sync_slide_animation__switch", 0) == 1;
            boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
            if (z) {
                return isSlideAnimLocalSwitchOn;
            }
            if (z2 != isSlideAnimLocalSwitchOn) {
                iu4.k().u("local_slide_animation__switch", z2);
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? iu4.k().h("local_slide_animation__switch", false) : invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.mTipsAutoPlayInVideoChannel : invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.mTipsAutoPlayInVideoMiddle : invokeV.booleanValue;
    }

    public boolean isUploadOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            k98 k98Var = this.mUploadAndClearModule;
            if (k98Var == null) {
                return false;
            }
            return k98Var.c();
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoCardMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.mIsVideoCardMute : invokeV.booleanValue;
    }

    public boolean isVideoChannelRelogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.isVideoChannelRelogin : invokeV.booleanValue;
    }

    @Modify(description = "是否访问预览机", type = 1)
    public boolean isVisitPreviewServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.mIsVisitPreviewServer : invokeV.booleanValue;
    }

    public boolean isYYSwitchStatusIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, "yy");
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadMoreLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? SwitchManager.getInstance().findType("need_more_logs") == 1 : invokeV.booleanValue;
    }

    public void onAccountChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048704, this) == null) {
            iu4 k = iu4.k();
            this.isYYLive = Boolean.valueOf(k.h("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
        }
    }

    public void putVideoRecord(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048705, this, str, i) == null) || li.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        ul4 ul4Var = null;
        int i2 = size - 1;
        int i3 = i2;
        while (true) {
            if (i3 < 0) {
                break;
            }
            ul4 ul4Var2 = this.mVideoWatchTimeRecord.get(i3);
            if (!str.equals(ul4Var2.a())) {
                i3--;
            } else if (ul4Var2.b() == i) {
                return;
            } else {
                r1 = i3 == i2;
                ul4Var = ul4Var2;
            }
        }
        if (ul4Var != null) {
            ul4Var.c(i);
            if (r1) {
                return;
            }
            this.mVideoWatchTimeRecord.remove(ul4Var);
            this.mVideoWatchTimeRecord.addLast(ul4Var);
            return;
        }
        ul4 ul4Var3 = new ul4(str, i);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(ul4Var3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(ul4Var3);
    }

    public void recordAcceleratorServer(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048706, this, str, str2) == null) {
            this.mAcceleratorMap.put(str, str2);
        }
    }

    public void registerScreenSizeChangeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048707, this) == null) {
            ng.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.3
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
        if ((interceptable == null || interceptable.invokeL(1048708, this, str) == null) && this.mAcceleratorMap.containsKey(str)) {
            this.mAcceleratorMap.remove(str);
        }
    }

    public void removeTempString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.tempStrings.remove(str);
        }
    }

    public void saveHomeRecommendItemClickTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048710, this) == null) {
            iu4.k().x("key_home_recommend_item_click_time", System.currentTimeMillis());
        }
    }

    public void setActiveTimeStamp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048711, this) == null) && getActiveTimeStamp() == 0) {
            iu4.k().x("key_active_timestamp", System.currentTimeMillis());
        }
    }

    public void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, str) == null) {
            this.mActivityId = str;
        }
    }

    public void setAdFloatViewData(ww4 ww4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, ww4Var) == null) {
            this.adFloatViewData = ww4Var;
        }
    }

    public void setAdVertiSementData(yw4 yw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048714, this, yw4Var) == null) {
            this.mAdVertiSementConfigData = yw4Var;
        }
    }

    public void setAnimAverageFpsThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i) == null) {
            this.mAnimFpsSyncThreshold = i;
            iu4.k().w("anim_avg_fps_threshold", i);
        }
    }

    public void setAnimAvgFps(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048716, this, str, i) == null) || li.isEmpty(str) || i < 0) {
            return;
        }
        iu4 k = iu4.k();
        k.w(str + "_anim_benchmark_avg_suffix", i);
    }

    public void setAnimAvgFpsCount(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048717, this, str, i) == null) || li.isEmpty(str) || i < 0) {
            return;
        }
        iu4 k = iu4.k();
        k.w(str + "_anim_benchmark_times_suffix", i);
    }

    public void setAnimComputedFps(String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048718, this, str, i) == null) || li.isEmpty(str)) {
            return;
        }
        iu4.k().w(str, i);
        if (!"anim_switch_slide".equals(str) || isAnimEnable(str)) {
            return;
        }
        setSlideAnimLocalSwitch(false);
    }

    public void setAuditPackageSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
            this.mIsAuditPackageSwitchOn = z;
        }
    }

    public void setBaiduIdForAnti(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048720, this, str) == null) && iu4.k().q("key_baiduid_for_anti", null) == null) {
            iu4.k().y("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBaiduidCookieSwitch(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i) == null) {
            this.isBaiduidCookieSwitch = i == 1;
        }
    }

    public void setBannerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            this.mBannerText = str;
        }
    }

    public void setBrowseMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048724, this, z) == null) {
            this.browseMode = z;
        }
    }

    public void setBusinessAccount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048725, this, z) == null) {
            this.isBusinessAccount = z;
        }
    }

    public void setCanShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048726, this, z) == null) {
            this.canShowPermDlg = z;
        }
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048727, this, z) == null) {
            this.mCanWebViewActivityShowProgress = z;
        }
    }

    public void setChannelConfigModel(qy4 qy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, qy4Var) == null) {
            this.mChannelConfigModel = qy4Var;
        }
    }

    public void setClipboardDelayTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048729, this, z) == null) {
            this.mClipboardDelayTime = z;
        }
    }

    public void setCpuFlopsDuration(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048730, this, i) == null) || i < 0) {
            return;
        }
        this.mCpuFlopsDur = i;
        iu4.k().w("cpu_flops_dura", i);
    }

    public void setCpuThreshold(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i) == null) {
            this.mCpuThreshold = i;
            iu4.k().w("cpu_flops_dura_threshold", i);
        }
    }

    public void setCurrentClickTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048732, this, j) == null) {
            this.currentClickTime = j;
        }
    }

    public void setDanmuSwitchOpen(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048733, this, z) == null) {
            this.isDanmuSwitchOpen = z;
            iu4.k().u("key_video_danmu_switch", z);
        }
    }

    public void setEnableBenchmark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048734, this, z) == null) {
            this.mEnableBenchmark = z;
            iu4.k().u("enable_benchmark", z);
        }
    }

    public void setEnableVideoVerticalPreload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048735, this, z) == null) {
            this.enableVideoVerticalPreload = z;
        }
    }

    public void setExceptInsertAdDiaShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048736, this, z) == null) {
            this.isExceptInsertAdDiaShow = z;
        }
    }

    public void setFirstOpenScheme(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048737, this, uri) == null) {
            this.firstOpenScheme = uri;
        }
    }

    public void setFlutterPluginLoadSuccess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048738, this, z) == null) {
            this.mIsFlutterPluginLoadSuccess = z;
        }
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048739, this, z) == null) {
            this.mForceRefreshHomeRecommend = z;
        }
    }

    public void setFromFeedVideoClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048740, this, z) == null) {
            this.mIsFromFeedVideoClick = z;
        }
    }

    public void setFromWhichSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, str) == null) {
            this.fromWhichSearchSource = str;
        }
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048742, this, z) == null) {
            this.mFrsContentViewLoadingShow = z;
        }
    }

    public void setFrsCurTabType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048743, this, i) == null) {
            this.mFrsCurTabType = i;
        }
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z) == null) {
            this.mFrsRootViewLoadingShow = z;
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z) == null) {
            this.mHasAgreeToPlay = z;
        }
    }

    public void setHasDownloadEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
            this.hasDownloadEmotion = z;
        }
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048747, this, z) == null) {
            this.hasPerformedFirstLoginTest = z;
            iu4.k().u("has_performed_first_login_test", z);
        }
    }

    public void setHasShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z) == null) {
            this.hasShowPermDlg = z;
        }
    }

    public void setHomeInsertAdData(ox4 ox4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, ox4Var) == null) {
            this.mHomeInsertAdData = ox4Var;
        }
    }

    public void setHomePageStyleAbTest(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048750, this, i) == null) {
            this.mHomePageStyleAbTest = i;
        }
    }

    public void setHomepageInterestConfig(px4 px4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048751, this, px4Var) == null) {
            this.homepageInterestConfigData = px4Var;
        }
    }

    public void setHostWhiteList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, list) == null) {
            this.mHostWhiteList = list;
        }
    }

    public void setHotSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, str) == null) {
            this.mHotSearch = str;
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048754, this, str) == null) {
            this.invokeSource = str;
        }
    }

    public void setIsJumpFromVideoMiddleView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048755, this, z) == null) {
            this.mIsJumpFromVideoMiddleView = z;
        }
    }

    public void setIsNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048756, this, z) == null) {
            this.mIsInNeedReuseVideoPlayer = z;
        }
    }

    public void setIsNeedShowPbCommentFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048757, this, z) == null) {
            this.mIsNeedShowCommentFloat = z;
        }
    }

    public void setIsOpenTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048758, this, z) == null) {
            this.mIsOpenTrack = z;
        }
    }

    public void setIsOutNeedReuseVideoPlayer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z) == null) {
            this.mIsOutNeedReuseVideoPlayer = z;
        }
    }

    public void setIsRecommendPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048760, this, z) == null) {
            this.isRecommendPage = z;
        }
    }

    public void setLFUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048761, this, str) == null) {
            this.mLFUser = str;
        }
    }

    public void setLFUserTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, str) == null) {
            this.mLFUserTaskId = str;
        }
    }

    public void setLastResumeTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048763, this, j) == null) {
            this.lastResumeTime = j;
        }
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, hashMap) == null) {
            this.liveForumMap = hashMap;
        }
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048765, this, mercatorData) == null) {
            this.mMercatorData = mercatorData;
        }
    }

    public void setMercatorRequestFromHomePageTabFeedFragment(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048766, this, z) == null) {
            this.isMercatorRequestFromHomePageTabFeedFragment = z;
        }
    }

    public void setMissionEntranceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048767, this, str) == null) {
            this.mMissionEntranceIcon = str;
        }
    }

    public void setMissionEntranceObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048768, this, str) == null) {
            this.mMissionEntranceObjSource = str;
        }
    }

    public void setMissionEntranceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048769, this, str) == null) {
            this.mMissionEntranceUrl = str;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048770, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setNewUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048771, this, z) == null) {
            this.isNewUser = z;
        }
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048772, this, newUserRedPackageData) == null) {
            this.mNewUserRedPackageData = newUserRedPackageData;
        }
    }

    public void setNewUserRedPackageShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048773, this, z) == null) {
            this.isNewUserRedPackageShowed = z;
            iu4.k().u("key_task_system_new_user_popup_show_number", z);
        }
    }

    public void setPbToHomeUpdateData(fq4 fq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048774, this, fq4Var) == null) {
            this.mPbToHomeUpdateData = fq4Var;
        }
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048775, this, jSONObject) == null) {
            if (this.mPcdnConfigData == null) {
                this.mPcdnConfigData = new n78();
            }
            this.mPcdnConfigData.d(jSONObject);
        }
    }

    public void setProfileGameCenterKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048776, this, str) == null) {
            this.mProfileGameCenterKey = str;
        }
    }

    public void setPubEnvValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048777, this, str) == null) {
            this.mPubEnvValue = str;
        }
    }

    public void setPushDialogLoopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048778, this, j) == null) {
            this.pushDialogLoopTime = j;
        }
    }

    public void setPushDialogShowTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048779, this, j) == null) {
            this.pushDialogShowTime = j;
        }
    }

    public void setReloginVideoMiddleBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048780, this, bundle) == null) {
            this.reloginVideoMiddleBundle = bundle;
        }
    }

    public void setSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048781, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048782, this, str) == null) {
            this.schemaForStartOtherAppAfterSwanApp = str;
        }
    }

    public void setShakeData(zx4 zx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048783, this, zx4Var) == null) {
            this.mShakeData = zx4Var;
        }
    }

    public void setSharePanelConfData(ay4 ay4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048784, this, ay4Var) == null) {
            this.mSharePanelConfData = ay4Var;
        }
    }

    public void setSharePanelText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048785, this, str) == null) {
            this.mSharePanelText = str;
        }
    }

    public void setShouldShowHomeLocalCompleteInfoCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048786, this, z) == null) {
            this.shouldShowHomeLocalCompleteInfoCard = z;
        }
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048787, this, z) == null) {
            this.mShowShoubaiDynamicGuide = z;
        }
    }

    public void setShowVoiceFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048788, this, z) == null) {
            this.mIsShowVoiceFloat = z;
        }
    }

    public void setShowedInterestGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048789, this, z) == null) {
            this.showedInterestGuide = z;
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048790, this, z) == null) {
            iu4.k().u("local_slide_animation__switch", z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
        }
    }

    public void setSyncModel(ty4 ty4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048791, this, ty4Var) == null) {
            this.syncModel = ty4Var;
        }
    }

    public void setSyncYYSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048792, this, z) == null) {
            this.isYYLive = Boolean.valueOf(z);
            iu4 k = iu4.k();
            k.u("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void setTempString(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048793, this, str, str2) == null) {
            this.tempStrings.put(str, str2);
        }
    }

    public void setTiebaPlusConfigData(TiebaPlusConfigData tiebaPlusConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048794, this, tiebaPlusConfigData) == null) {
            this.mTiebaPlusConfigData = tiebaPlusConfigData;
        }
    }

    public void setTipsAutoPlayInVideoChannel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048795, this, z) == null) {
            this.mTipsAutoPlayInVideoChannel = z;
        }
    }

    public void setTipsAutoPlayInVideoMiddle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048796, this, z) == null) {
            this.mTipsAutoPlayInVideoMiddle = z;
        }
    }

    public void setUbsABTestJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048797, this, jSONArray) == null) {
            this.mUbsABTestJsonArray = jSONArray;
        }
    }

    public void setUpgradePopWindowConfig(cy4 cy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048798, this, cy4Var) == null) {
            this.upgradePopWindowConfig = cy4Var;
        }
    }

    public void setUploadAndClearModule(k98 k98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048799, this, k98Var) == null) {
            this.mUploadAndClearModule = k98Var;
        }
    }

    public void setVideoCardMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048800, this, z) == null) {
            this.mIsVideoCardMute = z;
        }
    }

    public void setVideoChannelAttentionRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048801, this, redIcon) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048802, this, redIcon) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048803, this, z) == null) {
            this.isVideoChannelRelogin = z;
        }
    }

    public void setVideoCurrentFrame(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048804, this, bitmap) == null) {
            this.mVideoCurrentFrame = bitmap;
        }
    }

    public void setVideoEventsConfig(fy4 fy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048805, this, fy4Var) == null) {
            fy4 fy4Var2 = this.videoEventsConfig;
            if (fy4Var2 == null) {
                this.videoEventsConfig = fy4Var;
            } else if (fy4Var2.a(fy4Var)) {
            } else {
                this.videoEventsConfig = fy4Var;
            }
        }
    }

    public void setVideoRedIconInterval(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048806, this, i) == null) {
            this.videoRedIconInterval = i;
        }
    }

    public void setVideoTestType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048807, this, str) == null) {
            this.videoTestType = str;
        }
    }

    public void setVisitPreviewServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048808, this, z) == null) {
            this.mIsVisitPreviewServer = z;
        }
    }

    public void setVoiceRoomConfig(@Nullable gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048809, this, gy4Var) == null) {
            this.voiceRoomConfig = gy4Var;
        }
    }

    public void setWalletSignLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048810, this, str) == null) {
            this.mWalletSignLink = str;
        }
    }

    public void setWlConfigData(iy4 iy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048811, this, iy4Var) == null) {
            this.mWlConfigData = iy4Var;
        }
    }

    public void setWorksAddTopicMaxNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048812, this, i) == null) {
            this.worksAddTopicMaxNum = i;
        }
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048813, this, yYLiveConfig) == null) {
            this.mYYLiveConfig = yYLiveConfig;
        }
    }

    public void setYYLiveTabConfig(c29 c29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048814, this, c29Var) == null) {
            this.mYYLiveTabConfig = c29Var;
        }
    }

    public void setYyCloudSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048815, this, str) == null) {
            this.yyCloudSwitch = str;
            iu4.k().y("key_yy_cloud_switch", str);
        }
    }

    public void startOneGame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048816, this) == null) && this.mStartGameClicked) {
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
        if (interceptable == null || interceptable.invokeZ(1048722, this, z) == null) {
            this.isBaiduidCookieSwitch = z;
        }
    }
}
