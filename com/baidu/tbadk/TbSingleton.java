package com.baidu.tbadk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tieba.debugtool.annotation.Modify;
import com.baidu.tieba.debugtool.annotation.ModifyClass;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.wallet.YYLiveConfig;
import d.a.c.e.p.k;
import d.a.m0.r.q.e1;
import d.a.m0.s.c.e0;
import d.a.m0.s.c.f;
import d.a.m0.s.c.f0;
import d.a.m0.s.c.g;
import d.a.m0.s.e.b;
import d.a.m0.s.e.e;
import d.a.n0.k2.p.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
@ModifyClass
/* loaded from: classes3.dex */
public final class TbSingleton {
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_010 = 2;
    public static final int HOME_PAGE_STYLE_AB_TEST_100 = 4;
    public static final int PB_SUB_COMMENT_NUMBER = 4;
    public static TbSingleton mInstance;
    public f adFloatViewData;
    public String baiduIdForAnti;
    public Calendar calendar;
    public boolean hasPerformedFirstLoginTest;
    public boolean isNewUserRedPackageShowed;
    public boolean isRecommendPage;
    public boolean isShowBackLabel;
    public String isSwitchActivity;
    public Boolean isYYLive;
    public String mActivityId;
    public g mAdVertiSementConfigData;
    public String mBannerText;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public b mChannelConfigModel;
    public boolean mClipboardDelayTime;
    public boolean mForceRefreshHomeRecommend;
    public int mFrsCurTabType;
    public List<String> mHostWhiteList;
    public String mHotSearch;
    public boolean mIsAuditPackageSwitchOn;
    public boolean mIsOpenTrack;
    public String mLFUser;
    public String mLFUserTaskId;
    public MercatorModel.MercatorData mMercatorData;
    public String mMissionEntranceIcon;
    public String mMissionEntranceObjSource;
    public String mMissionEntranceUrl;
    public NewGodData mNewGodData;
    public NewUserRedPackageData mNewUserRedPackageData;
    public e1 mPbToHomeUpdateData;
    public a mPcdnConfigData;
    public String mProfileGameCenterKey;
    public String mPubEnvValue;
    public String mSampleId;
    public f0 mSharePanelConfData;
    public String mSharePanelText;
    public boolean mShowCallFans;
    public boolean mShowHomeFloatRefreshButton;
    public boolean mShowShoubaiDynamicGuide;
    public boolean mShowVivoBadge;
    public d.a.n0.r2.d.b mUploadAndClearModule;
    public LinkedList<d.a.m0.g.a> mVideoWatchTimeRecord;
    public String mWalletSignLink;
    public YYLiveConfig mYYLiveConfig;
    public String schemaForStartOtherAppAfterSwanApp;
    public e syncModel;
    public String videoTestType;
    public String yyCloudSwitch;
    public ArrayList<String> testUrls = new ArrayList<>();
    public final long THREE_DAY_MILLISECOND = 259200000;
    public long pushDialogLoopTime = StringHelper.MS_TO_HOUR;
    public long pushDialogShowTime = StringHelper.MS_TO_MIN * 5;
    public long lastResumeTime = 0;
    public boolean canShowPermDlg = false;
    public boolean hasShowPermDlg = false;
    public boolean isNewUser = false;
    public boolean mHasAgreeToPlay = false;
    public e0 mShakeData = null;
    public String invokeSource = "";
    public boolean mFrsRootViewLoadingShow = false;
    public boolean mFrsContentViewLoadingShow = false;
    public boolean mIsVideoCardMute = true;
    public boolean mEnableBenchmark = false;
    public int mCpuFlopsDur = -1;
    public int mCpuThreshold = Integer.MAX_VALUE;
    public int mAnimFpsSyncThreshold = 0;
    public int mIsNotchScreen = -1;
    public int mIsCutoutScreen = -1;
    public boolean mStartGameClicked = false;
    public boolean mIsVisitPreviewServer = false;
    public boolean hasDownloadEmotion = false;
    public int mHomePageStyleAbTest = 0;
    public HashMap<Long, String> liveForumMap = new HashMap<>();
    public boolean mShowaRightFloatView = true;
    public boolean mCanWebViewActivityShowProgress = true;
    public boolean mDistanceAccuracy = true;
    public boolean mDistanceAccuracyChecked = false;
    public boolean isInFrs = false;
    public long appFirstInstallTime = 0;
    public long appLastUpdateTime = 0;
    public long activeTimeStamp = 0;
    public boolean isAddBanner = false;
    public boolean browseMode = false;
    public final String mBaseActivity = "BaseActivity";
    public final String mBaseFragmentActivity = "BaseFragmentActivity";
    public final String mFlutterPageActivity = "FlutterPageActivity";
    public final BroadcastReceiver mHeadSetStateReceiver = new BroadcastReceiver() { // from class: com.baidu.tbadk.TbSingleton.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                boolean z = false;
                if (intent.getIntExtra("state", 0) != 0 && intent.getIntExtra("state", 0) == 1) {
                    z = true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921398, Boolean.valueOf(z)));
            }
        }
    };

    public TbSingleton() {
        this.mShowHomeFloatRefreshButton = false;
        this.mShowVivoBadge = false;
        this.isNewUserRedPackageShowed = false;
        this.hasPerformedFirstLoginTest = false;
        setIsOpenTrack(d.a.m0.r.d0.b.j().g("key_is_open_track", false));
        setProfileGameCenterKey(d.a.m0.r.d0.b.j().p("profile_swan_app_key", ""));
        setHomePageStyleAbTest(d.a.m0.r.d0.b.j().k("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(d.a.m0.r.d0.b.j().p("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(d.a.m0.r.d0.b.j().p("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(d.a.m0.r.d0.b.j().p("index_activity_abtest_obj_source", ""));
        setAuditPackageSwitch(d.a.m0.r.d0.b.j().g("audit_package_switch", false));
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        setUbsSampleId(j.p("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), ""));
        setShowShoubaiDynamicGuide(d.a.m0.r.d0.b.j().k("key_is_show_shoubai_dynamic_guide", 0) == 1);
        this.mShowHomeFloatRefreshButton = d.a.m0.r.d0.b.j().k("key_home_refresh_button_test", 0) == 1;
        setClipboardDelayTime(d.a.m0.r.d0.b.j().g("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        d.a.c.e.m.e.a().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.1
            @Override // java.lang.Runnable
            public void run() {
                TbSingleton.this.registerScreenSizeChangeTask();
            }
        });
        this.mShowVivoBadge = d.a.m0.r.d0.b.j().g("key_show_vivo_badge", false);
        this.mChannelConfigModel = new b();
        this.calendar = Calendar.getInstance();
        this.isNewUserRedPackageShowed = d.a.m0.r.d0.b.j().g("key_task_system_new_user_popup_show_number", false);
        this.hasPerformedFirstLoginTest = d.a.m0.r.d0.b.j().g("has_performed_first_login_test", false);
        this.yyCloudSwitch = d.a.m0.r.d0.b.j().p("key_yy_cloud_switch", null);
    }

    private void getAppInstallUpdateTime() {
        try {
            PackageInfo packageInfo = TbadkCoreApplication.getInst().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getPackageName(), 0);
            this.appFirstInstallTime = packageInfo.firstInstallTime;
            this.appLastUpdateTime = packageInfo.lastUpdateTime;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static TbSingleton getInstance() {
        if (mInstance == null) {
            synchronized (TbSingleton.class) {
                if (mInstance == null) {
                    mInstance = new TbSingleton();
                }
            }
        }
        return mInstance;
    }

    private void getYYSwitchStatus() {
        if (this.yyCloudSwitch == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921545, null));
            this.yyCloudSwitch = "";
        }
    }

    private void initBenchmarkData() {
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
        this.mEnableBenchmark = d.a.m0.r.d0.b.j().g("enable_benchmark", true);
        this.mCpuThreshold = d.a.m0.r.d0.b.j().k("cpu_flops_dura_threshold", Integer.MAX_VALUE);
        this.mAnimFpsSyncThreshold = d.a.m0.r.d0.b.j().k("anim_avg_fps_threshold", 0);
    }

    private void setUbsSampleId(String str) {
        this.mSampleId = str;
    }

    public boolean canShowPermDialog() {
        return this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - d.a.m0.r.d0.b.j().l("key_first_enter_app_timestamp", 0L) > 259200000;
    }

    public boolean checkLiveForumByFid(long j) {
        return !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j)));
    }

    public void clearVideoRecord() {
        LinkedList<d.a.m0.g.a> linkedList = this.mVideoWatchTimeRecord;
        if (linkedList != null) {
            linkedList.clear();
        }
    }

    public long getActiveTimeStamp() {
        if (this.activeTimeStamp == 0) {
            this.activeTimeStamp = d.a.m0.r.d0.b.j().l("key_active_timestamp", 0L);
        }
        return this.activeTimeStamp;
    }

    public String getActivityId() {
        return this.mActivityId;
    }

    public f getAdFloatViewData() {
        return this.adFloatViewData;
    }

    public String getAdVertiComment() {
        g gVar = this.mAdVertiSementConfigData;
        return gVar != null ? gVar.c() : "";
    }

    public g getAdVertiSementData() {
        return this.mAdVertiSementConfigData;
    }

    public Integer getAnimAvgFps(String str) {
        if (k.isEmpty(str)) {
            return 0;
        }
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        return Integer.valueOf(j.k(str + "_anim_benchmark_avg_suffix", 0));
    }

    public Integer getAnimAvgFpsCount(String str) {
        if (k.isEmpty(str)) {
            return 0;
        }
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        return Integer.valueOf(j.k(str + "_anim_benchmark_times_suffix", 0));
    }

    public int getAnimComputedFps(String str) {
        if (k.isEmpty(str)) {
            return -1;
        }
        return d.a.m0.r.d0.b.j().k(str, -1);
    }

    public int getAnimFpsSyncThreshold() {
        return this.mAnimFpsSyncThreshold;
    }

    public long getAppFirstInstallTime() {
        if (this.appFirstInstallTime == 0) {
            getAppInstallUpdateTime();
        }
        return this.appFirstInstallTime;
    }

    public long getAppLastUpdateTime() {
        if (this.appLastUpdateTime == 0) {
            getAppInstallUpdateTime();
        }
        return this.appLastUpdateTime;
    }

    public String getBaiduIdForAnti() {
        if (this.baiduIdForAnti == null) {
            this.baiduIdForAnti = d.a.m0.r.d0.b.j().p("key_baiduid_for_anti", null);
        }
        return this.baiduIdForAnti;
    }

    public String getBannerText() {
        return this.mBannerText;
    }

    public b getChannelConfigModel() {
        return this.mChannelConfigModel;
    }

    public boolean getClipboardDelayTime() {
        return this.mClipboardDelayTime;
    }

    public int getCpuFlopsDuration() {
        if (this.mCpuFlopsDur < 0) {
            this.mCpuFlopsDur = d.a.m0.r.d0.b.j().k("cpu_flops_dura", 0);
        }
        return this.mCpuFlopsDur;
    }

    public int getCpuFlopsDurationSyncThreshold() {
        return this.mCpuThreshold;
    }

    public String getData() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.calendar.get(1);
        int i3 = this.calendar.get(5);
        sb.append(i2);
        sb.append(this.calendar.get(2) + 1);
        sb.append(i3);
        return sb.toString();
    }

    public boolean getForceRefreshHomeRecommend() {
        return this.mForceRefreshHomeRecommend;
    }

    public int getFrsCurTabType() {
        return this.mFrsCurTabType;
    }

    public int getHomePageStyleAbTest() {
        return this.mHomePageStyleAbTest;
    }

    public List<String> getHostWhiteList() {
        return this.mHostWhiteList;
    }

    public String getHotSearch() {
        return this.mHotSearch;
    }

    public String getInvokeSource() {
        return this.invokeSource;
    }

    public String getLFUser() {
        return this.mLFUser;
    }

    public String getLFUserTaskId() {
        return this.mLFUserTaskId;
    }

    public long getLastResumeTime() {
        if (this.lastResumeTime == 0) {
            this.lastResumeTime = d.a.m0.r.d0.b.j().l("last_resume_time", 0L);
        }
        return this.lastResumeTime;
    }

    public MercatorModel.MercatorData getMercatorData() {
        return this.mMercatorData;
    }

    public String getMissionEntranceIcon() {
        return this.mMissionEntranceIcon;
    }

    public String getMissionEntranceObjSource() {
        return this.mMissionEntranceObjSource;
    }

    public String getMissionEntranceUrl() {
        return this.mMissionEntranceUrl;
    }

    public String getModName() {
        d.a.n0.r2.d.b bVar = this.mUploadAndClearModule;
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    public NewGodData getNewGodData() {
        return this.mNewGodData;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        return this.mNewUserRedPackageData;
    }

    public e1 getPbToHomeUpdateData() {
        return this.mPbToHomeUpdateData;
    }

    public a getPcdnConfigData() {
        return this.mPcdnConfigData;
    }

    public String getProfileGameCenterKey() {
        return this.mProfileGameCenterKey;
    }

    @Modify(description = "配置预览机pub_env参数，1强制访问线上沙盒环境，2强制访问小流量环境", type = 1)
    public String getPubEnvValue() {
        return this.mPubEnvValue;
    }

    public long getPushDialogLoopTime() {
        return this.pushDialogLoopTime;
    }

    public long getPushDialogShowTime() {
        return this.pushDialogShowTime;
    }

    public String getSampleId() {
        return this.mSampleId;
    }

    public String getSchemaForStartOtherAppAfterSwanApp() {
        return this.schemaForStartOtherAppAfterSwanApp;
    }

    public e0 getShakeData() {
        return this.mShakeData;
    }

    public f0 getSharePanelConfData() {
        return this.mSharePanelConfData;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public e getSyncModel() {
        return this.syncModel;
    }

    public boolean getSyncYYSwitch() {
        if (this.isYYLive == null) {
            d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
            this.isYYLive = Boolean.valueOf(j.g("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
        }
        return this.isYYLive.booleanValue();
    }

    public LinkedList<d.a.m0.g.a> getVideoRecordList() {
        return this.mVideoWatchTimeRecord;
    }

    public String getVideoTestType() {
        return this.videoTestType;
    }

    public String getWalletSignLink() {
        return this.mWalletSignLink;
    }

    public YYLiveConfig getYYLiveConfig() {
        return this.mYYLiveConfig;
    }

    public boolean hasAgreeToPlay() {
        return this.mHasAgreeToPlay;
    }

    public boolean hasDownloadEmotion() {
        return this.hasDownloadEmotion;
    }

    public boolean hasPerformedFirstLoginTest() {
        return this.hasPerformedFirstLoginTest;
    }

    public boolean isAnimEnable(String str) {
        if (isEnableBenchmark()) {
            if (getCpuFlopsDuration() > getCpuFlopsDurationSyncThreshold()) {
                return false;
            }
            return !isAnimFpsComputed(str) || getAnimComputedFps(str) >= getAnimFpsSyncThreshold();
        }
        return true;
    }

    public boolean isAnimFpsComputed(String str) {
        return !k.isEmpty(str) && getAnimComputedFps(str) >= 0;
    }

    public boolean isAuditPackageSwitchOn() {
        return this.mIsAuditPackageSwitchOn;
    }

    public boolean isBrowseMode() {
        return this.browseMode;
    }

    public boolean isCanWebViewActivityShowProgress() {
        return this.mCanWebViewActivityShowProgress;
    }

    public boolean isClearOffPack() {
        d.a.n0.r2.d.b bVar = this.mUploadAndClearModule;
        if (bVar == null) {
            return false;
        }
        return bVar.b();
    }

    public boolean isCutoutScreen(Activity activity) {
        if (this.mIsCutoutScreen < 0) {
            this.mIsCutoutScreen = UtilHelper.isCutoutScreen(activity) ? 1 : 0;
        }
        return this.mIsCutoutScreen == 1;
    }

    public boolean isDebugToolMode() {
        return false;
    }

    public boolean isEnableBenchmark() {
        return this.mEnableBenchmark;
    }

    public boolean isFrsLoadingViewHided() {
        return (this.mFrsRootViewLoadingShow || this.mFrsContentViewLoadingShow) ? false : true;
    }

    public boolean isIsOpenTrack() {
        return this.mIsOpenTrack;
    }

    public boolean isNewUser() {
        return this.isNewUser;
    }

    public boolean isNewUserRedPackageShowed() {
        return this.isNewUserRedPackageShowed;
    }

    public boolean isNotchScreen(Activity activity) {
        if (this.mIsNotchScreen < 0) {
            this.mIsNotchScreen = UtilHelper.isNotchScreen(activity) ? 1 : 0;
        }
        return this.mIsNotchScreen == 1;
    }

    public boolean isPbPreloadSwitchOn() {
        return SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1;
    }

    public boolean isRecommendPage() {
        return this.isRecommendPage;
    }

    public boolean isShowHomeFloatRefreshButton() {
        return this.mShowHomeFloatRefreshButton;
    }

    public boolean isShowRightFloatView(int i2) {
        f fVar = this.adFloatViewData;
        if (fVar == null) {
            return false;
        }
        if (i2 != 0) {
            if (i2 != 1 || StringUtils.isNull(fVar.c()) || StringUtils.isNull(this.adFloatViewData.d())) {
                return false;
            }
        } else if (StringUtils.isNull(fVar.a()) || StringUtils.isNull(this.adFloatViewData.b())) {
            return false;
        }
        return true;
    }

    public boolean isShowShoubaiDynamicGuide() {
        return this.mShowShoubaiDynamicGuide;
    }

    public boolean isShowStartLiveEntry() {
        getYYSwitchStatus();
        return StringHelper.equals(this.yyCloudSwitch, FastLoginFeature.SSOLoginType.YY) || !getSyncYYSwitch();
    }

    public boolean isShowVivoBadge() {
        return this.mShowVivoBadge;
    }

    public boolean isSlideAnimEnable() {
        boolean z = d.a.m0.r.d0.b.j().k("slide_local_switch_is_clicked", 0) == 1;
        boolean z2 = d.a.m0.r.d0.b.j().k("sync_slide_animation__switch", 0) == 1;
        boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
        if (z) {
            return isSlideAnimLocalSwitchOn;
        }
        if (z2 != isSlideAnimLocalSwitchOn) {
            d.a.m0.r.d0.b.j().t("local_slide_animation__switch", z2);
        }
        return z2;
    }

    public boolean isSlideAnimLocalSwitchOn() {
        return d.a.m0.r.d0.b.j().g("local_slide_animation__switch", false);
    }

    public boolean isUploadOffPack() {
        d.a.n0.r2.d.b bVar = this.mUploadAndClearModule;
        if (bVar == null) {
            return false;
        }
        return bVar.c();
    }

    public boolean isVideoCardMute() {
        return this.mIsVideoCardMute;
    }

    @Modify(description = "是否访问预览机", type = 1)
    public boolean isVisitPreviewServer() {
        return this.mIsVisitPreviewServer;
    }

    public boolean isYYSwitchStatusIsOn() {
        getYYSwitchStatus();
        return StringHelper.equals(this.yyCloudSwitch, FastLoginFeature.SSOLoginType.YY);
    }

    public boolean needUploadMoreLog() {
        return SwitchManager.getInstance().findType("need_more_logs") == 1;
    }

    public void onAccountChange() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        this.isYYLive = Boolean.valueOf(j.g("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), true));
    }

    public void putVideoRecord(String str, int i2) {
        if (k.isEmpty(str)) {
            return;
        }
        if (this.mVideoWatchTimeRecord == null) {
            this.mVideoWatchTimeRecord = new LinkedList<>();
        }
        int size = this.mVideoWatchTimeRecord.size();
        d.a.m0.g.a aVar = null;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < 0) {
                break;
            }
            d.a.m0.g.a aVar2 = this.mVideoWatchTimeRecord.get(i4);
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
        d.a.m0.g.a aVar3 = new d.a.m0.g.a(str, i2);
        if (size >= 10) {
            this.mVideoWatchTimeRecord.pollFirst();
            this.mVideoWatchTimeRecord.addLast(aVar3);
            return;
        }
        this.mVideoWatchTimeRecord.addLast(aVar3);
    }

    public void registerScreenSizeChangeTask() {
        d.a.c.e.m.e.a().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.3
            @Override // java.lang.Runnable
            public void run() {
                CustomMessageTask customMessageTask = new CustomMessageTask(2921414, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tbadk.TbSingleton.3.1
                    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
                    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                        return new CustomResponsedMessage<>(2921414);
                    }
                });
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
                MessageManager.getInstance().registerTask(customMessageTask);
            }
        });
    }

    public void setActiveTimeStamp() {
        if (getActiveTimeStamp() == 0) {
            d.a.m0.r.d0.b.j().w("key_active_timestamp", System.currentTimeMillis());
        }
    }

    public void setActivityId(String str) {
        this.mActivityId = str;
    }

    public void setAdFloatViewData(f fVar) {
        this.adFloatViewData = fVar;
    }

    public void setAdVertiSementData(g gVar) {
        this.mAdVertiSementConfigData = gVar;
    }

    public void setAnimAverageFpsThreshold(int i2) {
        this.mAnimFpsSyncThreshold = i2;
        d.a.m0.r.d0.b.j().v("anim_avg_fps_threshold", i2);
    }

    public void setAnimAvgFps(String str, int i2) {
        if (k.isEmpty(str) || i2 < 0) {
            return;
        }
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v(str + "_anim_benchmark_avg_suffix", i2);
    }

    public void setAnimAvgFpsCount(String str, int i2) {
        if (k.isEmpty(str) || i2 < 0) {
            return;
        }
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v(str + "_anim_benchmark_times_suffix", i2);
    }

    public void setAnimComputedFps(String str, int i2) {
        if (k.isEmpty(str)) {
            return;
        }
        d.a.m0.r.d0.b.j().v(str, i2);
        if (!"anim_switch_slide".equals(str) || isAnimEnable(str)) {
            return;
        }
        setSlideAnimLocalSwitch(false);
    }

    public void setAuditPackageSwitch(boolean z) {
        this.mIsAuditPackageSwitchOn = z;
    }

    public void setBaiduIdForAnti(String str) {
        if (d.a.m0.r.d0.b.j().p("key_baiduid_for_anti", null) == null) {
            d.a.m0.r.d0.b.j().x("key_baiduid_for_anti", str);
            this.baiduIdForAnti = str;
        }
    }

    public void setBannerText(String str) {
        this.mBannerText = str;
    }

    public void setBrowseMode(boolean z) {
        this.browseMode = z;
    }

    public void setCanShowPermDlg(boolean z) {
        this.canShowPermDlg = z;
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        this.mCanWebViewActivityShowProgress = z;
    }

    public void setChannelConfigModel(b bVar) {
        this.mChannelConfigModel = bVar;
    }

    public void setClipboardDelayTime(boolean z) {
        this.mClipboardDelayTime = z;
    }

    public void setCpuFlopsDuration(int i2) {
        if (i2 < 0) {
            return;
        }
        this.mCpuFlopsDur = i2;
        d.a.m0.r.d0.b.j().v("cpu_flops_dura", i2);
    }

    public void setCpuThreshold(int i2) {
        this.mCpuThreshold = i2;
        d.a.m0.r.d0.b.j().v("cpu_flops_dura_threshold", i2);
    }

    public void setEnableBenchmark(boolean z) {
        this.mEnableBenchmark = z;
        d.a.m0.r.d0.b.j().t("enable_benchmark", z);
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        this.mForceRefreshHomeRecommend = z;
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        this.mFrsContentViewLoadingShow = z;
    }

    public void setFrsCurTabType(int i2) {
        this.mFrsCurTabType = i2;
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        this.mFrsRootViewLoadingShow = z;
    }

    public void setHasAgreeToPlay(boolean z) {
        this.mHasAgreeToPlay = z;
    }

    public void setHasDownloadEmotion(boolean z) {
        this.hasDownloadEmotion = z;
    }

    public void setHasPerformedFirstLoginTest(boolean z) {
        this.hasPerformedFirstLoginTest = z;
        d.a.m0.r.d0.b.j().t("has_performed_first_login_test", z);
    }

    public void setHasShowPermDlg(boolean z) {
        this.hasShowPermDlg = z;
    }

    public void setHomePageStyleAbTest(int i2) {
        this.mHomePageStyleAbTest = i2;
    }

    public void setHostWhiteList(List<String> list) {
        this.mHostWhiteList = list;
    }

    public void setHotSearch(String str) {
        this.mHotSearch = str;
    }

    public void setInvokeSource(String str) {
        this.invokeSource = str;
    }

    public void setIsOpenTrack(boolean z) {
        this.mIsOpenTrack = z;
    }

    public void setIsRecommendPage(boolean z) {
        this.isRecommendPage = z;
    }

    public void setLFUser(String str) {
        this.mLFUser = str;
    }

    public void setLFUserTaskId(String str) {
        this.mLFUserTaskId = str;
    }

    public void setLastResumeTime(long j) {
        this.lastResumeTime = j;
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        this.liveForumMap = hashMap;
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        this.mMercatorData = mercatorData;
    }

    public void setMissionEntranceIcon(String str) {
        this.mMissionEntranceIcon = str;
    }

    public void setMissionEntranceObjSource(String str) {
        this.mMissionEntranceObjSource = str;
    }

    public void setMissionEntranceUrl(String str) {
        this.mMissionEntranceUrl = str;
    }

    public void setNewGodData(NewGodData newGodData) {
        this.mNewGodData = newGodData;
    }

    public void setNewUser(boolean z) {
        this.isNewUser = z;
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        this.mNewUserRedPackageData = newUserRedPackageData;
    }

    public void setNewUserRedPackageShowed(boolean z) {
        this.isNewUserRedPackageShowed = z;
        d.a.m0.r.d0.b.j().t("key_task_system_new_user_popup_show_number", z);
    }

    public void setPbToHomeUpdateData(e1 e1Var) {
        this.mPbToHomeUpdateData = e1Var;
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        if (this.mPcdnConfigData == null) {
            this.mPcdnConfigData = new a();
        }
        this.mPcdnConfigData.d(jSONObject);
    }

    public void setProfileGameCenterKey(String str) {
        this.mProfileGameCenterKey = str;
    }

    public void setPubEnvValue(String str) {
        this.mPubEnvValue = str;
    }

    public void setPushDialogLoopTime(long j) {
        this.pushDialogLoopTime = j;
    }

    public void setPushDialogShowTime(long j) {
        this.pushDialogShowTime = j;
    }

    public void setSampleId(String str) {
        this.mSampleId = str;
    }

    public void setSchemaForStartOtherAppAfterSwanApp(String str) {
        this.schemaForStartOtherAppAfterSwanApp = str;
    }

    public void setShakeData(e0 e0Var) {
        this.mShakeData = e0Var;
    }

    public void setSharePanelConfData(f0 f0Var) {
        this.mSharePanelConfData = f0Var;
    }

    public void setSharePanelText(String str) {
        this.mSharePanelText = str;
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        this.mShowShoubaiDynamicGuide = z;
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        d.a.m0.r.d0.b.j().t("local_slide_animation__switch", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
    }

    public void setSyncModel(e eVar) {
        this.syncModel = eVar;
    }

    public void setSyncYYSwitch(boolean z) {
        this.isYYLive = Boolean.valueOf(z);
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.t("key_is_yy_live" + TbadkCoreApplication.getCurrentAccount(), z);
    }

    public void setUploadAndClearModule(d.a.n0.r2.d.b bVar) {
        this.mUploadAndClearModule = bVar;
    }

    public void setVideoCardMute(boolean z) {
        this.mIsVideoCardMute = z;
    }

    public void setVideoTestType(String str) {
        this.videoTestType = str;
    }

    public void setVisitPreviewServer(boolean z) {
        this.mIsVisitPreviewServer = z;
    }

    public void setWalletSignLink(String str) {
        this.mWalletSignLink = str;
    }

    public void setYYLiveConfig(YYLiveConfig yYLiveConfig) {
        this.mYYLiveConfig = yYLiveConfig;
    }

    public void setYyCloudSwitch(String str) {
        this.yyCloudSwitch = str;
        d.a.m0.r.d0.b.j().x("key_yy_cloud_switch", str);
    }

    public void startOneGame() {
        if (this.mStartGameClicked) {
            this.mStartGameClicked = false;
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", "15471320").param("obj_source", "game_lauch_screen").param("obj_name", "可口大冒险").param("obj_param1", 1));
        }
    }
}
