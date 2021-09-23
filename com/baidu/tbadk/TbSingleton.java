package com.baidu.tbadk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.q0.b.d;
import c.a.q0.s.q.g1;
import c.a.q0.t.c.f;
import c.a.q0.t.c.f0;
import c.a.q0.t.c.g;
import c.a.q0.t.c.g0;
import c.a.q0.t.c.i0;
import c.a.q0.t.c.z;
import c.a.q0.t.e.b;
import c.a.q0.t.e.e;
import c.a.r0.p2.p.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.VideoRedIcon.RedIcon;
@ModifyClass
/* loaded from: classes6.dex */
public final class TbSingleton {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_010 = 2;
    public static final int HOME_PAGE_STYLE_AB_TEST_100 = 4;
    public static final int LOGIN_FROM_DEFAULT = -1;
    public static final int LOGIN_FROM_VIDEO_ATTENTION = 1;
    public static final int PB_SUB_COMMENT_NUMBER = 4;
    public static final int VIDEO_TAB_PB_SUB_COMMENT_NUMBER = 2;
    public static int loginFrom = -1;
    public static boolean mHasSetMode;
    public static TbSingleton mInstance;
    public static boolean mIsAbNightModeColor;
    public transient /* synthetic */ FieldHolder $fh;
    public final long THREE_DAY_MILLISECOND;
    public long activeTimeStamp;
    public f adFloatViewData;
    public long appFirstInstallTime;
    public long appLastUpdateTime;
    public String baiduIdForAnti;
    public boolean browseMode;
    public Calendar calendar;
    public boolean canShowPermDlg;
    public boolean enableVideoVerticalPreload;
    public String fromWhichSearchSource;
    public boolean hasDownloadEmotion;
    public boolean hasPerformedFirstLoginTest;
    public boolean hasShowPermDlg;
    public String invokeSource;
    public boolean isAddBanner;
    public boolean isInFrs;
    public boolean isItemTabVisible;
    public boolean isNewUser;
    public boolean isNewUserRedPackageShowed;
    public boolean isRecommendPage;
    public boolean isShowBackLabel;
    public String isSwitchActivity;
    public Boolean isYYLive;
    public long lastResumeTime;
    public HashMap<Long, String> liveForumMap;
    public String mActivityId;
    public g mAdVertiSementConfigData;
    public int mAnimFpsSyncThreshold;
    public String mBannerText;
    public final String mBaseActivity;
    public final String mBaseFragmentActivity;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public boolean mCanWebViewActivityShowProgress;
    public b mChannelConfigModel;
    public boolean mClipboardDelayTime;
    public int mCpuFlopsDur;
    public int mCpuThreshold;
    public boolean mDistanceAccuracy;
    public boolean mDistanceAccuracyChecked;
    public boolean mEnableBenchmark;
    public final String mFlutterPageActivity;
    public boolean mForceRefreshHomeRecommend;
    public boolean mFrsContentViewLoadingShow;
    public int mFrsCurTabType;
    public boolean mFrsRootViewLoadingShow;
    public boolean mHasAgreeToPlay;
    public final BroadcastReceiver mHeadSetStateReceiver;
    public int mHomePageStyleAbTest;
    public List<String> mHostWhiteList;
    public String mHotSearch;
    public boolean mIsAuditPackageSwitchOn;
    public int mIsCutoutScreen;
    public boolean mIsFromFeedVideoClick;
    public boolean mIsNeedShowCommentFloat;
    public int mIsNotchScreen;
    public boolean mIsOpenTrack;
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
    public g1 mPbToHomeUpdateData;
    public a mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public String mSampleId;
    public f0 mShakeData;
    public g0 mSharePanelConfData;
    public String mSharePanelText;
    public boolean mShowCallFans;
    public boolean mShowHomeFloatRefreshButton;
    public boolean mShowShoubaiDynamicGuide;
    public boolean mShowVivoBadge;
    public boolean mShowaRightFloatView;
    public boolean mStartGameClicked;
    public i0 mTiebaPlusConfigData;
    public boolean mTipsAutoPlayInVideoChannel;
    public boolean mTipsAutoPlayInVideoMiddle;
    public JSONArray mUbsABTestJsonArray;
    public c.a.r0.w2.d.b mUploadAndClearModule;
    public LinkedList<c.a.q0.h.a> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public YYLiveConfig mYYLiveConfig;
    public c.a.r0.e4.a mYYLiveTabConfig;
    public boolean needRefreshForumSquare;
    public long pushDialogLoopTime;
    public long pushDialogShowTime;
    public String schemaForStartOtherAppAfterSwanApp;
    public boolean showedInterestGuide;
    public e syncModel;
    public ArrayList<String> testUrls;
    public RedIcon videoChannelAttentionRedIcon;
    public RedIcon videoChannelRecommendRedIcon;
    public int videoRedIconInterval;
    public String videoTestType;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.testUrls = new ArrayList<>();
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
        this.mShowaRightFloatView = true;
        this.mShowVivoBadge = false;
        this.mCanWebViewActivityShowProgress = true;
        this.mDistanceAccuracy = true;
        this.mDistanceAccuracyChecked = false;
        this.isInFrs = false;
        this.mIsNeedShowCommentFloat = false;
        this.appFirstInstallTime = 0L;
        this.appLastUpdateTime = 0L;
        this.activeTimeStamp = 0L;
        this.isAddBanner = false;
        this.browseMode = false;
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
        setIsOpenTrack(c.a.q0.s.d0.b.j().g("key_is_open_track", false));
        setProfileGameCenterKey(c.a.q0.s.d0.b.j().p("profile_swan_app_key", ""));
        setHomePageStyleAbTest(c.a.q0.s.d0.b.j().k("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(c.a.q0.s.d0.b.j().p("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(c.a.q0.s.d0.b.j().p("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(c.a.q0.s.d0.b.j().p("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(c.a.q0.s.d0.b.j().g("audit_package_switch", false));
        setUbsSampleId(c.a.q0.s.d0.b.j().p("key_ubs_sample_id", ""));
        setShowShoubaiDynamicGuide(c.a.q0.s.d0.b.j().k("key_is_show_shoubai_dynamic_guide", 0) == 1);
        this.mShowHomeFloatRefreshButton = c.a.q0.s.d0.b.j().k("key_home_refresh_button_test", 0) == 1;
        setClipboardDelayTime(c.a.q0.s.d0.b.j().g("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        c.a.e.e.m.e.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.1
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
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
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
        this.mShowVivoBadge = c.a.q0.s.d0.b.j().g("key_show_vivo_badge", false);
        this.mChannelConfigModel = new b();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = c.a.q0.s.d0.b.j().g("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = c.a.q0.s.d0.b.j().g("has_performed_first_login_test", false);
        this.yyCloudSwitch = c.a.q0.s.d0.b.j().p("key_yy_cloud_switch", null);
    }

    private void getAppInstallUpdateTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            try {
                PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0);
                this.appFirstInstallTime = packageInfo.firstInstallTime;
                this.appLastUpdateTime = packageInfo.lastUpdateTime;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static TbSingleton getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.yyCloudSwitch == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
            this.yyCloudSwitch = "";
        }
    }

    private void initBenchmarkData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
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
            this.mEnableBenchmark = c.a.q0.s.d0.b.j().g("enable_benchmark", true);
            this.mCpuThreshold = c.a.q0.s.d0.b.j().k("cpu_flops_dura_threshold", Integer.MAX_VALUE);
            this.mAnimFpsSyncThreshold = c.a.q0.s.d0.b.j().k("anim_avg_fps_threshold", 0);
        }
    }

    private void setUbsSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public boolean canShowPermDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - c.a.q0.s.d0.b.j().l("key_first_enter_app_timestamp", 0L) > 259200000;
        }
        return invokeV.booleanValue;
    }

    public boolean checkLiveForumByFid(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) ? !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j2))) : invokeJ.booleanValue;
    }

    public void clearVideoRecord() {
        LinkedList<c.a.q0.h.a> linkedList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (linkedList = this.mVideoWatchTimeRecord) == null) {
            return;
        }
        linkedList.clear();
    }

    public long getActiveTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.activeTimeStamp == 0) {
                this.activeTimeStamp = c.a.q0.s.d0.b.j().l("key_active_timestamp", 0L);
            }
            return this.activeTimeStamp;
        }
        return invokeV.longValue;
    }

    public String getActivityId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mActivityId : (String) invokeV.objValue;
    }

    public f getAdFloatViewData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.adFloatViewData : (f) invokeV.objValue;
    }

    public String getAdVertiComment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.mAdVertiSementConfigData;
            return gVar != null ? gVar.c() : "";
        }
        return (String) invokeV.objValue;
    }

    public g getAdVertiSementData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdVertiSementConfigData : (g) invokeV.objValue;
    }

    public Integer getAnimAvgFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (k.isEmpty(str)) {
                return 0;
            }
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            return Integer.valueOf(j2.k(str + "_anim_benchmark_avg_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public Integer getAnimAvgFpsCount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (k.isEmpty(str)) {
                return 0;
            }
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            return Integer.valueOf(j2.k(str + "_anim_benchmark_times_suffix", 0));
        }
        return (Integer) invokeL.objValue;
    }

    public int getAnimComputedFps(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (k.isEmpty(str)) {
                return -1;
            }
            return c.a.q0.s.d0.b.j().k(str, -1);
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
                this.baiduIdForAnti = c.a.q0.s.d0.b.j().p("key_baiduid_for_anti", null);
            }
            return this.baiduIdForAnti;
        }
        return (String) invokeV.objValue;
    }

    public String getBannerText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mBannerText : (String) invokeV.objValue;
    }

    public b getChannelConfigModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mChannelConfigModel : (b) invokeV.objValue;
    }

    public boolean getClipboardDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mClipboardDelayTime : invokeV.booleanValue;
    }

    public int getCpuFlopsDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.mCpuFlopsDur < 0) {
                this.mCpuFlopsDur = c.a.q0.s.d0.b.j().k("cpu_flops_dura", 0);
            }
            return this.mCpuFlopsDur;
        }
        return invokeV.intValue;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mCpuThreshold : invokeV.intValue;
    }

    public String getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder();
            int i2 = this.calendar.get(1);
            int i3 = this.calendar.get(5);
            sb.append(i2);
            sb.append(this.calendar.get(2) + 1);
            sb.append(i3);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean getForceRefreshHomeRecommend() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mForceRefreshHomeRecommend : invokeV.booleanValue;
    }

    public String getFromWhichSearchSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.fromWhichSearchSource : (String) invokeV.objValue;
    }

    public int getFrsCurTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mFrsCurTabType : invokeV.intValue;
    }

    public int getHomePageStyleAbTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mHomePageStyleAbTest : invokeV.intValue;
    }

    public List<String> getHostWhiteList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mHostWhiteList : (List) invokeV.objValue;
    }

    public String getHotSearch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mHotSearch : (String) invokeV.objValue;
    }

    public String getInvokeSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.invokeSource : (String) invokeV.objValue;
    }

    public boolean getIsNeedShowPbCommentFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mIsNeedShowCommentFloat : invokeV.booleanValue;
    }

    public String getLFUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.mLFUser : (String) invokeV.objValue;
    }

    public String getLFUserTaskId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.mLFUserTaskId : (String) invokeV.objValue;
    }

    public long getLastResumeTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.lastResumeTime == 0) {
                this.lastResumeTime = c.a.q0.s.d0.b.j().l("last_resume_time", 0L);
            }
            return this.lastResumeTime;
        }
        return invokeV.longValue;
    }

    public MercatorModel.MercatorData getMercatorData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.mMercatorData : (MercatorModel.MercatorData) invokeV.objValue;
    }

    public String getMissionEntranceIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.mMissionEntranceIcon : (String) invokeV.objValue;
    }

    public String getMissionEntranceObjSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.mMissionEntranceObjSource : (String) invokeV.objValue;
    }

    public String getMissionEntranceUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.mMissionEntranceUrl : (String) invokeV.objValue;
    }

    public String getModName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            c.a.r0.w2.d.b bVar = this.mUploadAndClearModule;
            if (bVar == null) {
                return null;
            }
            return bVar.a();
        }
        return (String) invokeV.objValue;
    }

    public NewGodData getNewGodData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.mNewGodData : (NewGodData) invokeV.objValue;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.mNewUserRedPackageData : (NewUserRedPackageData) invokeV.objValue;
    }

    public g1 getPbToHomeUpdateData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mPbToHomeUpdateData : (g1) invokeV.objValue;
    }

    public a getPcdnConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.mPcdnConfigData : (a) invokeV.objValue;
    }

    public String getProfileGameCenterKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.mProfileGameCenterKey : (String) invokeV.objValue;
    }

    @Modify(description = "配置预览机pub_env参数，1强制访问线上沙盒环境，2强制访问小流量环境", type = 1)
    public String getPubEnvValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.mPubEnvValue : (String) invokeV.objValue;
    }

    public long getPushDialogLoopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.pushDialogLoopTime : invokeV.longValue;
    }

    public long getPushDialogShowTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.pushDialogShowTime : invokeV.longValue;
    }

    public String getSampleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.mSampleId : (String) invokeV.objValue;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.schemaForStartOtherAppAfterSwanApp : (String) invokeV.objValue;
    }

    public f0 getShakeData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.mShakeData : (f0) invokeV.objValue;
    }

    public g0 getSharePanelConfData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.mSharePanelConfData : (g0) invokeV.objValue;
    }

    public String getSharePanelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.mSharePanelText : (String) invokeV.objValue;
    }

    public boolean getShowedInterestGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.showedInterestGuide : invokeV.booleanValue;
    }

    public e getSyncModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.syncModel : (e) invokeV.objValue;
    }

    public boolean getSyncYYSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (this.isYYLive == null) {
                c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
                this.isYYLive = Boolean.valueOf(j2.g("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
            }
            return this.isYYLive.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public i0 getTiebaPlusConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.mTiebaPlusConfigData : (i0) invokeV.objValue;
    }

    public JSONArray getUbsABTestJsonArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.mUbsABTestJsonArray : (JSONArray) invokeV.objValue;
    }

    public RedIcon getVideoChannelAttentionRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.videoChannelAttentionRedIcon : (RedIcon) invokeV.objValue;
    }

    public RedIcon getVideoChannelRecommendRedIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.videoChannelRecommendRedIcon : (RedIcon) invokeV.objValue;
    }

    public LinkedList<c.a.q0.h.a> getVideoRecordList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.mVideoWatchTimeRecord : (LinkedList) invokeV.objValue;
    }

    public int getVideoRedIconInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.videoRedIconInterval : invokeV.intValue;
    }

    public String getVideoTestType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.videoTestType : (String) invokeV.objValue;
    }

    public String getWalletSignLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.mWalletSignLink : (String) invokeV.objValue;
    }

    public int getWorksAddTopicMaxNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.worksAddTopicMaxNum : invokeV.intValue;
    }

    public YYLiveConfig getYYLiveConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.mYYLiveConfig : (YYLiveConfig) invokeV.objValue;
    }

    public c.a.r0.e4.a getYYLiveTabConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.mYYLiveTabConfig : (c.a.r0.e4.a) invokeV.objValue;
    }

    public boolean hasAgreeToPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.mHasAgreeToPlay : invokeV.booleanValue;
    }

    public boolean hasDownloadEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.hasDownloadEmotion : invokeV.booleanValue;
    }

    public boolean hasPerformedFirstLoginTest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.hasPerformedFirstLoginTest : invokeV.booleanValue;
    }

    public boolean interestGuideShowCountInLimit(String str, z zVar) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048644, this, str, zVar)) == null) {
            if (StringUtils.isNull(str)) {
                return true;
            }
            String[] split = str.split(",");
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = 0;
            for (int length = split.length - 1; length >= 0; length--) {
                try {
                    i2 = (int) (((((currentTimeMillis - Long.parseLong(split[length])) / 1000) / 60) / 60) / 24);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i2 = 0;
                }
                if (i2 > zVar.f14774c) {
                    return i3 < zVar.f14775d;
                } else if (i3 >= zVar.f14775d - 1) {
                    return false;
                } else {
                    i3++;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean isAbNightModeColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (!mHasSetMode) {
                mIsAbNightModeColor = d.j();
                mHasSetMode = true;
            }
            return mIsAbNightModeColor;
        }
        return invokeV.booleanValue;
    }

    public boolean isAnimEnable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, str)) == null) ? !k.isEmpty(str) && getAnimComputedFps(str) >= 0 : invokeL.booleanValue;
    }

    public boolean isAuditPackageSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.mIsAuditPackageSwitchOn : invokeV.booleanValue;
    }

    public boolean isBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.browseMode : invokeV.booleanValue;
    }

    public boolean isCanWebViewActivityShowProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.mCanWebViewActivityShowProgress : invokeV.booleanValue;
    }

    public boolean isClearOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            c.a.r0.w2.d.b bVar = this.mUploadAndClearModule;
            if (bVar == null) {
                return false;
            }
            return bVar.b();
        }
        return invokeV.booleanValue;
    }

    public boolean isCutoutScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, activity)) == null) {
            if (this.mIsCutoutScreen < 0) {
                this.mIsCutoutScreen = UtilHelper.isCutoutScreen(activity) ? 1 : 0;
            }
            return this.mIsCutoutScreen == 1;
        }
        return invokeL.booleanValue;
    }

    public boolean isDebugToolMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isEnableBenchmark() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.mEnableBenchmark : invokeV.booleanValue;
    }

    public boolean isEnableVideoVerticalPreload() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.enableVideoVerticalPreload : invokeV.booleanValue;
    }

    public boolean isFromFeedVideoClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.mIsFromFeedVideoClick : invokeV.booleanValue;
    }

    public boolean isFrsLoadingViewHided() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? (this.mFrsRootViewLoadingShow || this.mFrsContentViewLoadingShow) ? false : true : invokeV.booleanValue;
    }

    public boolean isImRecForumShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (getUbsABTestJsonArray() == null) {
                return false;
            }
            for (int i2 = 0; i2 < getUbsABTestJsonArray().length(); i2++) {
                try {
                    JSONObject jSONObject = getUbsABTestJsonArray().getJSONObject(i2);
                    if (jSONObject != null && "12_8_rec_forum_a".equals(jSONObject.optString("sid"))) {
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.mIsOpenTrack : invokeV.booleanValue;
    }

    public boolean isNeedShowInterestGuide() {
        InterceptResult invokeV;
        long j2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048660, this)) != null) {
            return invokeV.booleanValue;
        }
        z interestBoardConfigData = TbadkCoreApplication.getInst().getInterestBoardConfigData();
        if (interestBoardConfigData == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long l = c.a.q0.s.d0.b.j().l("key_new_user_logon_time", 0L);
        long l2 = c.a.q0.s.d0.b.j().l("key_home_recommend_item_click_time", 0L);
        long l3 = c.a.q0.s.d0.b.j().l("key_select_interest_flag", 0L);
        long l4 = c.a.q0.s.d0.b.j().l("key_app_launch_time", 0L);
        String p = c.a.q0.s.d0.b.j().p("key_interest_guide_show", "");
        boolean isSameDay = TimeHelper.isSameDay(System.currentTimeMillis() - (interestBoardConfigData.f14772a * 86400000), l);
        boolean isTargetTimeInTimeBlock = TimeHelper.isTargetTimeInTimeBlock(l2, l, System.currentTimeMillis());
        int i2 = (int) (((((currentTimeMillis - l4) / 1000) / 60) / 60) / 24);
        if (!isSameDay || isTargetTimeInTimeBlock) {
            j2 = 0;
        } else {
            j2 = 0;
            if (l3 == 0) {
                z = true;
                return (!z || ((l4 > j2 ? 1 : (l4 == j2 ? 0 : -1)) == 0 && i2 >= interestBoardConfigData.f14773b)) && interestGuideShowCountInLimit(p, interestBoardConfigData) && !getShowedInterestGuide();
            }
        }
        z = false;
        if (z) {
        }
    }

    public boolean isNewUser() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.isNewUser : invokeV.booleanValue;
    }

    public boolean isNewUserRedPackageShowed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.isNewUserRedPackageShowed : invokeV.booleanValue;
    }

    public boolean isNotchScreen(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048663, this, activity)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1 : invokeV.booleanValue;
    }

    public boolean isRecommendPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.isRecommendPage : invokeV.booleanValue;
    }

    public boolean isShowHomeFloatRefreshButton() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.mShowHomeFloatRefreshButton : invokeV.booleanValue;
    }

    public boolean isShowRightFloatView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048667, this, i2)) == null) {
            f fVar = this.adFloatViewData;
            if (fVar == null) {
                return false;
            }
            if (i2 != 0) {
                if (i2 != 1 || StringUtils.isNull(fVar.h()) || StringUtils.isNull(this.adFloatViewData.k())) {
                    return false;
                }
            } else if (StringUtils.isNull(fVar.b()) || StringUtils.isNull(this.adFloatViewData.e())) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean isShowShoubaiDynamicGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.mShowShoubaiDynamicGuide : invokeV.booleanValue;
    }

    public boolean isShowStartLiveEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, FastLoginFeature.SSOLoginType.YY) || !getSyncYYSwitch();
        }
        return invokeV.booleanValue;
    }

    public boolean isShowVivoBadge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.mShowVivoBadge : invokeV.booleanValue;
    }

    public boolean isSlideAnimEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            boolean z = c.a.q0.s.d0.b.j().k("slide_local_switch_is_clicked", 0) == 1;
            boolean z2 = c.a.q0.s.d0.b.j().k("sync_slide_animation__switch", 0) == 1;
            boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
            if (z) {
                return isSlideAnimLocalSwitchOn;
            }
            if (z2 != isSlideAnimLocalSwitchOn) {
                c.a.q0.s.d0.b.j().t("local_slide_animation__switch", z2);
            }
            return z2;
        }
        return invokeV.booleanValue;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? c.a.q0.s.d0.b.j().g("local_slide_animation__switch", false) : invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.mTipsAutoPlayInVideoChannel : invokeV.booleanValue;
    }

    public boolean isTipsAutoPlayInVideoMiddle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.mTipsAutoPlayInVideoMiddle : invokeV.booleanValue;
    }

    public boolean isUploadOffPack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            c.a.r0.w2.d.b bVar = this.mUploadAndClearModule;
            if (bVar == null) {
                return false;
            }
            return bVar.c();
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoCardMute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.mIsVideoCardMute : invokeV.booleanValue;
    }

    @Modify(description = "是否访问预览机", type = 1)
    public boolean isVisitPreviewServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.mIsVisitPreviewServer : invokeV.booleanValue;
    }

    public boolean isYYSwitchStatusIsOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            getYYSwitchStatus();
            return StringHelper.equals(this.yyCloudSwitch, FastLoginFeature.SSOLoginType.YY);
        }
        return invokeV.booleanValue;
    }

    public boolean needUploadMoreLog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? SwitchManager.getInstance().findType("need_more_logs") == 1 : invokeV.booleanValue;
    }

    public void onAccountChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048680, this) == null) {
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            this.isYYLive = Boolean.valueOf(j2.g("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
        }
    }

    public void putVideoRecord(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048681, this, str, i2) == null) || k.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        c.a.q0.h.a aVar = null;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < 0) {
                break;
            }
            c.a.q0.h.a aVar2 = this.mVideoWatchTimeRecord.get(i4);
            if (!str.equals(aVar2.a())) {
                i4--;
            } else if (aVar2.b() == i2) {
                return;
            } else {
                r1 = i4 == i3;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            aVar.c(i2);
            if (r1) {
                return;
            }
            this.mVideoWatchTimeRecord.remove(aVar);
            this.mVideoWatchTimeRecord.addLast(aVar);
            return;
        }
        c.a.q0.h.a aVar3 = new c.a.q0.h.a(str, i2);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(aVar3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(aVar3);
    }

    public void registerScreenSizeChangeTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            c.a.e.e.m.e.a().post(new Runnable(this) { // from class: com.baidu.tbadk.TbSingleton.3
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
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
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
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
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

    public void saveHomeRecommendItemClickTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            c.a.q0.s.d0.b.j().w("key_home_recommend_item_click_time", System.currentTimeMillis());
        }
    }

    public void setActiveTimeStamp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048684, this) == null) && getActiveTimeStamp() == 0) {
            c.a.q0.s.d0.b.j().w("key_active_timestamp", System.currentTimeMillis());
        }
    }

    public void setActivityId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            this.mActivityId = str;
        }
    }

    public void setAdFloatViewData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, fVar) == null) {
            this.adFloatViewData = fVar;
        }
    }

    public void setAdVertiSementData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, gVar) == null) {
            this.mAdVertiSementConfigData = gVar;
        }
    }

    public void setAnimAverageFpsThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048688, this, i2) == null) {
            this.mAnimFpsSyncThreshold = i2;
            c.a.q0.s.d0.b.j().v("anim_avg_fps_threshold", i2);
        }
    }

    public void setAnimAvgFps(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048689, this, str, i2) == null) || k.isEmpty(str) || i2 < 0) {
            return;
        }
        c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
        j2.v(str + "_anim_benchmark_avg_suffix", i2);
    }

    public void setAnimAvgFpsCount(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048690, this, str, i2) == null) || k.isEmpty(str) || i2 < 0) {
            return;
        }
        c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
        j2.v(str + "_anim_benchmark_times_suffix", i2);
    }

    public void setAnimComputedFps(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048691, this, str, i2) == null) || k.isEmpty(str)) {
            return;
        }
        c.a.q0.s.d0.b.j().v(str, i2);
        if (!"anim_switch_slide".equals(str) || isAnimEnable(str)) {
            return;
        }
        setSlideAnimLocalSwitch(false);
    }

    public void setAuditPackageSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048692, this, z) == null) {
            this.mIsAuditPackageSwitchOn = z;
        }
    }

    public void setBaiduIdForAnti(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048693, this, str) == null) && c.a.q0.s.d0.b.j().p("key_baiduid_for_anti", null) == null) {
            c.a.q0.s.d0.b.j().x("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBannerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, str) == null) {
            this.mBannerText = str;
        }
    }

    public void setBrowseMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048695, this, z) == null) {
            this.browseMode = z;
        }
    }

    public void setCanShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z) == null) {
            this.canShowPermDlg = z;
        }
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048697, this, z) == null) {
            this.mCanWebViewActivityShowProgress = z;
        }
    }

    public void setChannelConfigModel(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048698, this, bVar) == null) {
            this.mChannelConfigModel = bVar;
        }
    }

    public void setClipboardDelayTime(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048699, this, z) == null) {
            this.mClipboardDelayTime = z;
        }
    }

    public void setCpuFlopsDuration(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048700, this, i2) == null) || i2 < 0) {
            return;
        }
        this.mCpuFlopsDur = i2;
        c.a.q0.s.d0.b.j().v("cpu_flops_dura", i2);
    }

    public void setCpuThreshold(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i2) == null) {
            this.mCpuThreshold = i2;
            c.a.q0.s.d0.b.j().v("cpu_flops_dura_threshold", i2);
        }
    }

    public void setEnableBenchmark(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048702, this, z) == null) {
            this.mEnableBenchmark = z;
            c.a.q0.s.d0.b.j().t("enable_benchmark", z);
        }
    }

    public void setEnableVideoVerticalPreload(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048703, this, z) == null) {
            this.enableVideoVerticalPreload = z;
        }
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048704, this, z) == null) {
            this.mForceRefreshHomeRecommend = z;
        }
    }

    public void setFromFeedVideoClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048705, this, z) == null) {
            this.mIsFromFeedVideoClick = z;
        }
    }

    public void setFromWhichSearchSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, str) == null) {
            this.fromWhichSearchSource = str;
        }
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048707, this, z) == null) {
            this.mFrsContentViewLoadingShow = z;
        }
    }

    public void setFrsCurTabType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048708, this, i2) == null) {
            this.mFrsCurTabType = i2;
        }
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048709, this, z) == null) {
            this.mFrsRootViewLoadingShow = z;
        }
    }

    public void setHasAgreeToPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048710, this, z) == null) {
            this.mHasAgreeToPlay = z;
        }
    }

    public void setHasDownloadEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048711, this, z) == null) {
            this.hasDownloadEmotion = z;
        }
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048712, this, z) == null) {
            this.hasPerformedFirstLoginTest = z;
            c.a.q0.s.d0.b.j().t("has_performed_first_login_test", z);
        }
    }

    public void setHasShowPermDlg(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048713, this, z) == null) {
            this.hasShowPermDlg = z;
        }
    }

    public void setHomePageStyleAbTest(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048714, this, i2) == null) {
            this.mHomePageStyleAbTest = i2;
        }
    }

    public void setHostWhiteList(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048715, this, list) == null) {
            this.mHostWhiteList = list;
        }
    }

    public void setHotSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048716, this, str) == null) {
            this.mHotSearch = str;
        }
    }

    public void setInvokeSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.invokeSource = str;
        }
    }

    public void setIsNeedShowPbCommentFloat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z) == null) {
            this.mIsNeedShowCommentFloat = z;
        }
    }

    public void setIsOpenTrack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048719, this, z) == null) {
            this.mIsOpenTrack = z;
        }
    }

    public void setIsRecommendPage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048720, this, z) == null) {
            this.isRecommendPage = z;
        }
    }

    public void setLFUser(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048721, this, str) == null) {
            this.mLFUser = str;
        }
    }

    public void setLFUserTaskId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048722, this, str) == null) {
            this.mLFUserTaskId = str;
        }
    }

    public void setLastResumeTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048723, this, j2) == null) {
            this.lastResumeTime = j2;
        }
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, hashMap) == null) {
            this.liveForumMap = hashMap;
        }
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048725, this, mercatorData) == null) {
            this.mMercatorData = mercatorData;
        }
    }

    public void setMissionEntranceIcon(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048726, this, str) == null) {
            this.mMissionEntranceIcon = str;
        }
    }

    public void setMissionEntranceObjSource(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048727, this, str) == null) {
            this.mMissionEntranceObjSource = str;
        }
    }

    public void setMissionEntranceUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048728, this, str) == null) {
            this.mMissionEntranceUrl = str;
        }
    }

    public void setNewGodData(NewGodData newGodData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048729, this, newGodData) == null) {
            this.mNewGodData = newGodData;
        }
    }

    public void setNewUser(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048730, this, z) == null) {
            this.isNewUser = z;
        }
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048731, this, newUserRedPackageData) == null) {
            this.mNewUserRedPackageData = newUserRedPackageData;
        }
    }

    public void setNewUserRedPackageShowed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048732, this, z) == null) {
            this.isNewUserRedPackageShowed = z;
            c.a.q0.s.d0.b.j().t("key_task_system_new_user_popup_show_number", z);
        }
    }

    public void setPbToHomeUpdateData(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048733, this, g1Var) == null) {
            this.mPbToHomeUpdateData = g1Var;
        }
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048734, this, jSONObject) == null) {
            if (this.mPcdnConfigData == null) {
                this.mPcdnConfigData = new a();
            }
            this.mPcdnConfigData.d(jSONObject);
        }
    }

    public void setProfileGameCenterKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            this.mProfileGameCenterKey = str;
        }
    }

    public void setPubEnvValue(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, str) == null) {
            this.mPubEnvValue = str;
        }
    }

    public void setPushDialogLoopTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048737, this, j2) == null) {
            this.pushDialogLoopTime = j2;
        }
    }

    public void setPushDialogShowTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048738, this, j2) == null) {
            this.pushDialogShowTime = j2;
        }
    }

    public void setSampleId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048739, this, str) == null) {
            this.mSampleId = str;
        }
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048740, this, str) == null) {
            this.schemaForStartOtherAppAfterSwanApp = str;
        }
    }

    public void setShakeData(f0 f0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, f0Var) == null) {
            this.mShakeData = f0Var;
        }
    }

    public void setSharePanelConfData(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, g0Var) == null) {
            this.mSharePanelConfData = g0Var;
        }
    }

    public void setSharePanelText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048743, this, str) == null) {
            this.mSharePanelText = str;
        }
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048744, this, z) == null) {
            this.mShowShoubaiDynamicGuide = z;
        }
    }

    public void setShowedInterestGuide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048745, this, z) == null) {
            this.showedInterestGuide = z;
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048746, this, z) == null) {
            c.a.q0.s.d0.b.j().t("local_slide_animation__switch", z);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
        }
    }

    public void setSyncModel(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, eVar) == null) {
            this.syncModel = eVar;
        }
    }

    public void setSyncYYSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048748, this, z) == null) {
            this.isYYLive = Boolean.valueOf(z);
            c.a.q0.s.d0.b j2 = c.a.q0.s.d0.b.j();
            j2.t("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
        }
    }

    public void setTiebaPlusConfigData(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, i0Var) == null) {
            this.mTiebaPlusConfigData = i0Var;
        }
    }

    public void setTipsAutoPlayInVideoChannel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048750, this, z) == null) {
            this.mTipsAutoPlayInVideoChannel = z;
        }
    }

    public void setTipsAutoPlayInVideoMiddle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048751, this, z) == null) {
            this.mTipsAutoPlayInVideoMiddle = z;
        }
    }

    public void setUbsABTestJsonArray(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, jSONArray) == null) {
            this.mUbsABTestJsonArray = jSONArray;
        }
    }

    public void setUploadAndClearModule(c.a.r0.w2.d.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048753, this, bVar) == null) {
            this.mUploadAndClearModule = bVar;
        }
    }

    public void setVideoCardMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048754, this, z) == null) {
            this.mIsVideoCardMute = z;
        }
    }

    public void setVideoChannelAttentionRedIcon(RedIcon redIcon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048755, this, redIcon) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048756, this, redIcon) == null) {
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

    public void setVideoRedIconInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048757, this, i2) == null) {
            this.videoRedIconInterval = i2;
        }
    }

    public void setVideoTestType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048758, this, str) == null) {
            this.videoTestType = str;
        }
    }

    public void setVisitPreviewServer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048759, this, z) == null) {
            this.mIsVisitPreviewServer = z;
        }
    }

    public void setWalletSignLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048760, this, str) == null) {
            this.mWalletSignLink = str;
        }
    }

    public void setWorksAddTopicMaxNum(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048761, this, i2) == null) {
            this.worksAddTopicMaxNum = i2;
        }
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048762, this, yYLiveConfig) == null) {
            this.mYYLiveConfig = yYLiveConfig;
        }
    }

    public void setYYLiveTabConfig(c.a.r0.e4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048763, this, aVar) == null) {
            this.mYYLiveTabConfig = aVar;
        }
    }

    public void setYyCloudSwitch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048764, this, str) == null) {
            this.yyCloudSwitch = str;
            c.a.q0.s.d0.b.j().x("key_yy_cloud_switch", str);
        }
    }

    public void startOneGame() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048765, this) == null) && this.mStartGameClicked) {
            this.mStartGameClicked = false;
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", "15471320").param("obj_source", "game_lauch_screen").param("obj_name", "可口大冒险").param("obj_param1", 1));
        }
    }

    @NonNull
    public String getAdVertiComment(boolean z, boolean z2, @NonNull String str) {
        InterceptResult invokeCommon;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z) {
                g gVar = this.mAdVertiSementConfigData;
                c2 = gVar != null ? gVar.c() : "";
                if (StringUtils.isNull(c2)) {
                    return str;
                }
            } else if (!z2) {
                return str;
            } else {
                g gVar2 = this.mAdVertiSementConfigData;
                c2 = gVar2 != null ? gVar2.c() : "";
                if (StringUtils.isNull(c2)) {
                    return str;
                }
            }
            return c2;
        }
        return (String) invokeCommon.objValue;
    }
}
