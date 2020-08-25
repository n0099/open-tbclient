package com.baidu.tbadk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.coreExtra.model.b;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.play.cyberPlayer.a;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class TbSingleton {
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_010 = 2;
    public static final int HOME_PAGE_STYLE_AB_TEST_100 = 4;
    private static TbSingleton mInstance = null;
    private boolean isRecommendPage;
    public String mCallFansTid;
    public boolean mCanCallFans;
    public b mChannelConfigModel;
    private boolean mClipboardDelayTime;
    private boolean mForceRefreshHomeRecommend;
    private int mFrsCurTabType;
    private List<String> mHostWhiteList;
    private String mHotSearch;
    private boolean mIsOpenTrack;
    private boolean mIsShowPersonCenterLiteGame;
    private MercatorModel.MercatorData mMercatorData;
    private String mMissionEntranceIcon;
    private String mMissionEntranceObjSource;
    private String mMissionEntranceUrl;
    private NewGodData mNewGodData;
    private NewUserRedPackageData mNewUserRedPackageData;
    private ba mPbToHomeUpdateData;
    private a mPcdnConfigData;
    private String mProfileGameCenterKey;
    private String mPubEnvValue;
    private String mSampleId;
    private ad mSharePanelConfData;
    private String mSharePanelText;
    public boolean mShowCallFans;
    private boolean mShowHomeFloatRefreshButton;
    private boolean mShowShoubaiDynamicGuide;
    private boolean mShowVivoBadge;
    private LinkedList<com.baidu.tbadk.d.a> mVideoWatchTimeRecord;
    private String mWalletSignLink;
    private String videoTestType;
    public ArrayList<String> testUrls = new ArrayList<>();
    private final long THREE_DAY_MILLISECOND = Config.THREAD_IMAGE_SAVE_MAX_TIME;
    private long pushDialogLoopTime = at.MS_TO_HOUR;
    private long pushDialogShowTime = 5 * at.MS_TO_MIN;
    private long lastResumeTime = 0;
    private boolean canShowPermDlg = false;
    private boolean hasShowPermDlg = false;
    private boolean isNewUser = false;
    private boolean mHasAgreeToPlay = false;
    private ac mShakeData = null;
    private String invokeSource = "";
    private boolean mFrsRootViewLoadingShow = false;
    private boolean mFrsContentViewLoadingShow = false;
    private boolean isVideoEnterMiddlePage = true;
    private boolean mIsVideoCardMute = true;
    private boolean mIsVideoCardMuteInHeadSet = false;
    private boolean mEnableBenchmark = false;
    private int mCpuFlopsDur = -1;
    private int mCpuThreshold = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int mAnimFpsSyncThreshold = 0;
    private int mIsNotchScreen = -1;
    private int mIsCutoutScreen = -1;
    public boolean mStartGameClicked = false;
    private boolean mIsVisitPreviewServer = false;
    private boolean hasDownloadEmotion = false;
    private int mHomePageStyleAbTest = 0;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
    private boolean mCanWebViewActivityShowProgress = true;
    private boolean mDistanceAccuracy = true;
    private boolean mDistanceAccuracyChecked = false;
    private final BroadcastReceiver mHeadSetStateReceiver = new BroadcastReceiver() { // from class: com.baidu.tbadk.TbSingleton.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                if (intent.getIntExtra("state", 0) != 0 && intent.getIntExtra("state", 0) == 1) {
                    z = true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921398, Boolean.valueOf(z)));
            }
        }
    };

    private TbSingleton() {
        this.mShowHomeFloatRefreshButton = false;
        this.mShowVivoBadge = false;
        setIsOpenTrack(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_is_open_track", false));
        setProfileGameCenterKey(com.baidu.tbadk.core.sharedPref.b.bik().getString("profile_swan_app_key", ""));
        setHomePageStyleAbTest(com.baidu.tbadk.core.sharedPref.b.bik().getInt("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(com.baidu.tbadk.core.sharedPref.b.bik().getString("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(com.baidu.tbadk.core.sharedPref.b.bik().getString("index_activity_abtest_url", ""));
        setMissionEntranceObjSource(com.baidu.tbadk.core.sharedPref.b.bik().getString("index_activity_abtest_obj_source", ""));
        setShowPersonCenterLiteGame(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("person_center_show_lite_game", true));
        setUbsSampleId(com.baidu.tbadk.core.sharedPref.b.bik().getString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), ""));
        setShowShoubaiDynamicGuide(com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_is_show_shoubai_dynamic_guide", 0) == 1);
        this.mShowHomeFloatRefreshButton = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_home_refresh_button_test", 0) == 1;
        setClipboardDelayTime(com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", false));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        e.mS().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.1
            @Override // java.lang.Runnable
            public void run() {
                TbSingleton.this.registerScreenSizeChangeTask();
            }
        });
        this.mShowVivoBadge = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_show_vivo_badge", false);
        this.mChannelConfigModel = new b();
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

    public boolean isIsOpenTrack() {
        return this.mIsOpenTrack;
    }

    public void setIsOpenTrack(boolean z) {
        this.mIsOpenTrack = z;
    }

    public void setIsRecommendPage(boolean z) {
        this.isRecommendPage = z;
    }

    public boolean isRecommendPage() {
        return this.isRecommendPage;
    }

    public void putVideoRecord(String str, int i) {
        com.baidu.tbadk.d.a aVar;
        boolean z;
        if (!at.isEmpty(str)) {
            if (this.mVideoWatchTimeRecord == null) {
                this.mVideoWatchTimeRecord = new LinkedList<>();
            }
            int size = this.mVideoWatchTimeRecord.size();
            int i2 = size - 1;
            while (true) {
                if (i2 < 0) {
                    aVar = null;
                    z = false;
                    break;
                }
                aVar = this.mVideoWatchTimeRecord.get(i2);
                if (!str.equals(aVar.getKey())) {
                    i2--;
                } else if (aVar.getValue() != i) {
                    z = i2 == size + (-1);
                } else {
                    return;
                }
            }
            if (aVar != null) {
                aVar.setValue(i);
                if (!z) {
                    this.mVideoWatchTimeRecord.remove(aVar);
                    this.mVideoWatchTimeRecord.addLast(aVar);
                    return;
                }
                return;
            }
            com.baidu.tbadk.d.a aVar2 = new com.baidu.tbadk.d.a(str, i);
            if (size >= 10) {
                this.mVideoWatchTimeRecord.pollFirst();
                this.mVideoWatchTimeRecord.addLast(aVar2);
                return;
            }
            this.mVideoWatchTimeRecord.addLast(aVar2);
        }
    }

    public LinkedList<com.baidu.tbadk.d.a> getVideoRecordList() {
        return this.mVideoWatchTimeRecord;
    }

    public void clearVideoRecord() {
        if (this.mVideoWatchTimeRecord != null) {
            this.mVideoWatchTimeRecord.clear();
        }
    }

    public long getPushDialogLoopTime() {
        return this.pushDialogLoopTime;
    }

    public void setPushDialogLoopTime(long j) {
        this.pushDialogLoopTime = j;
    }

    public long getPushDialogShowTime() {
        return this.pushDialogShowTime;
    }

    public void setPushDialogShowTime(long j) {
        this.pushDialogShowTime = j;
    }

    public boolean canShowPermDialog() {
        return this.canShowPermDlg && !this.hasShowPermDlg && System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_first_enter_app_timestamp", 0L) > Config.THREAD_IMAGE_SAVE_MAX_TIME;
    }

    public void setHasShowPermDlg(boolean z) {
        this.hasShowPermDlg = z;
    }

    public void setCanShowPermDlg(boolean z) {
        this.canShowPermDlg = z;
    }

    public long getLastResumeTime() {
        if (this.lastResumeTime == 0) {
            this.lastResumeTime = com.baidu.tbadk.core.sharedPref.b.bik().getLong("last_resume_time", 0L);
        }
        return this.lastResumeTime;
    }

    public void setLastResumeTime(long j) {
        this.lastResumeTime = j;
    }

    public boolean isNewUser() {
        return this.isNewUser;
    }

    public void setNewUser(boolean z) {
        this.isNewUser = z;
    }

    public void setHasAgreeToPlay(boolean z) {
        this.mHasAgreeToPlay = z;
    }

    public boolean hasAgreeToPlay() {
        return this.mHasAgreeToPlay;
    }

    public boolean isVideoEnterMiddlePage() {
        return true;
    }

    public void setFrsRootViewLoadingShow(boolean z) {
        this.mFrsRootViewLoadingShow = z;
    }

    public void setFrsContentViewLoadingShow(boolean z) {
        this.mFrsContentViewLoadingShow = z;
    }

    public boolean isFrsLoadingViewHided() {
        return (this.mFrsRootViewLoadingShow || this.mFrsContentViewLoadingShow) ? false : true;
    }

    public void setVideoCardMute(boolean z) {
        if (isHeadsetPlugged()) {
            this.mIsVideoCardMuteInHeadSet = z;
        } else {
            this.mIsVideoCardMute = z;
        }
    }

    public boolean isVideoCardMute() {
        return isHeadsetPlugged() ? this.mIsVideoCardMuteInHeadSet : this.mIsVideoCardMute;
    }

    public void setLiveForumMap(HashMap<Long, String> hashMap) {
        this.liveForumMap = hashMap;
    }

    public boolean checkLiveForumByFid(long j) {
        return !StringUtils.isNull(this.liveForumMap.get(Long.valueOf(j)));
    }

    private void initBenchmarkData() {
        if (TbadkCoreApplication.getInst().getIsFirstUse()) {
            setCpuThreshold(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
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
        this.mEnableBenchmark = com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("enable_benchmark", true);
        this.mCpuThreshold = com.baidu.tbadk.core.sharedPref.b.bik().getInt("cpu_flops_dura_threshold", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mAnimFpsSyncThreshold = com.baidu.tbadk.core.sharedPref.b.bik().getInt("anim_avg_fps_threshold", 0);
    }

    public boolean isAnimFpsComputed(String str) {
        return !at.isEmpty(str) && getAnimComputedFps(str) >= 0;
    }

    public int getAnimComputedFps(String str) {
        if (at.isEmpty(str)) {
            return -1;
        }
        return com.baidu.tbadk.core.sharedPref.b.bik().getInt(str, -1);
    }

    public void setAnimComputedFps(String str, int i) {
        if (!at.isEmpty(str)) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(str, i);
            if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
                setSlideAnimLocalSwitch(false);
            }
        }
    }

    public Integer getAnimAvgFps(String str) {
        if (at.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.bik().getInt(str + "_anim_benchmark_avg_suffix", 0));
    }

    public void setAnimAvgFps(String str, int i) {
        if (!at.isEmpty(str) && i >= 0) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public Integer getAnimAvgFpsCount(String str) {
        if (at.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(com.baidu.tbadk.core.sharedPref.b.bik().getInt(str + "_anim_benchmark_times_suffix", 0));
    }

    public void setAnimAvgFpsCount(String str, int i) {
        if (!at.isEmpty(str) && i >= 0) {
            com.baidu.tbadk.core.sharedPref.b.bik().putInt(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("local_slide_animation__switch", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
    }

    public boolean isSlideAnimLocalSwitchOn() {
        return com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("local_slide_animation__switch", false);
    }

    public boolean isSlideAnimEnable() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.bik().getInt("slide_local_switch_is_clicked", 0) == 1;
        boolean z2 = com.baidu.tbadk.core.sharedPref.b.bik().getInt("sync_slide_animation__switch", 0) == 1;
        boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
        if (z) {
            return isSlideAnimLocalSwitchOn;
        }
        if (z2 != isSlideAnimLocalSwitchOn) {
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("local_slide_animation__switch", z2);
            return z2;
        }
        return z2;
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

    public int getCpuFlopsDuration() {
        if (this.mCpuFlopsDur < 0) {
            this.mCpuFlopsDur = com.baidu.tbadk.core.sharedPref.b.bik().getInt("cpu_flops_dura", 0);
        }
        return this.mCpuFlopsDur;
    }

    public void setCpuFlopsDuration(int i) {
        if (i >= 0) {
            this.mCpuFlopsDur = i;
            com.baidu.tbadk.core.sharedPref.b.bik().putInt("cpu_flops_dura", i);
        }
    }

    public void setEnableBenchmark(boolean z) {
        this.mEnableBenchmark = z;
        com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("enable_benchmark", z);
    }

    public boolean isEnableBenchmark() {
        return this.mEnableBenchmark;
    }

    public void setCpuThreshold(int i) {
        this.mCpuThreshold = i;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("cpu_flops_dura_threshold", i);
    }

    public void setAnimAverageFpsThreshold(int i) {
        this.mAnimFpsSyncThreshold = i;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("anim_avg_fps_threshold", i);
    }

    public int getCpuFlopsDurationSyncThreshold() {
        return this.mCpuThreshold;
    }

    public int getAnimFpsSyncThreshold() {
        return this.mAnimFpsSyncThreshold;
    }

    public void setShakeData(ac acVar) {
        this.mShakeData = acVar;
    }

    public ac getShakeData() {
        return this.mShakeData;
    }

    public boolean hasDownloadEmotion() {
        return this.hasDownloadEmotion;
    }

    public void setHasDownloadEmotion(boolean z) {
        this.hasDownloadEmotion = z;
    }

    public String getInvokeSource() {
        return this.invokeSource;
    }

    public void setInvokeSource(String str) {
        this.invokeSource = str;
    }

    public String getHotSearch() {
        return this.mHotSearch;
    }

    public void setHotSearch(String str) {
        this.mHotSearch = str;
    }

    public void setSharePanelText(String str) {
        this.mSharePanelText = str;
    }

    public String getSharePanelText() {
        return this.mSharePanelText;
    }

    public String getMissionEntranceUrl() {
        return this.mMissionEntranceUrl;
    }

    public void setMissionEntranceUrl(String str) {
        this.mMissionEntranceUrl = str;
    }

    public String getMissionEntranceIcon() {
        return this.mMissionEntranceIcon;
    }

    public void setMissionEntranceIcon(String str) {
        this.mMissionEntranceIcon = str;
    }

    public String getMissionEntranceObjSource() {
        return this.mMissionEntranceObjSource;
    }

    public void setMissionEntranceObjSource(String str) {
        this.mMissionEntranceObjSource = str;
    }

    public int getHomePageStyleAbTest() {
        return this.mHomePageStyleAbTest;
    }

    public void setHomePageStyleAbTest(int i) {
        this.mHomePageStyleAbTest = i;
    }

    private void setUbsSampleId(String str) {
        this.mSampleId = str;
    }

    private boolean isHeadsetPlugged() {
        return ((AudioManager) TbadkCoreApplication.getInst().getSystemService("audio")).isWiredHeadsetOn();
    }

    public boolean isShowPersonCenterLiteGame() {
        return this.mIsShowPersonCenterLiteGame;
    }

    public void setShowPersonCenterLiteGame(boolean z) {
        this.mIsShowPersonCenterLiteGame = z;
    }

    public String getProfileGameCenterKey() {
        return this.mProfileGameCenterKey;
    }

    public void setProfileGameCenterKey(String str) {
        this.mProfileGameCenterKey = str;
    }

    public boolean isNotchScreen(Activity activity) {
        if (this.mIsNotchScreen < 0) {
            this.mIsNotchScreen = UtilHelper.isNotchScreen(activity) ? 1 : 0;
        }
        return this.mIsNotchScreen == 1;
    }

    public boolean isCutoutScreen(Activity activity) {
        if (this.mIsCutoutScreen < 0) {
            this.mIsCutoutScreen = UtilHelper.isCutoutScreen(activity) ? 1 : 0;
        }
        return this.mIsCutoutScreen == 1;
    }

    public void startOneGame() {
        if (this.mStartGameClicked) {
            this.mStartGameClicked = false;
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swangame/ikyQxumlFXoxbTw4eVaZDHCGU4vSVvLI/?_baiduboxapp=%7B%22from%22%3A%221191003700000000%22%7D&callback=_bdbox_js_275&upgrade=0"));
            TiebaStatic.log(new aq("c13274").dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_id", "15471320").dD("obj_source", "game_lauch_screen").dD("obj_name", "可口大冒险").ai("obj_param1", 1));
        }
    }

    public void registerScreenSizeChangeTask() {
        e.mS().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.3
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

    public boolean isVisitPreviewServer() {
        return this.mIsVisitPreviewServer;
    }

    public void setVisitPreviewServer(boolean z) {
        this.mIsVisitPreviewServer = z;
    }

    public String getPubEnvValue() {
        return this.mPubEnvValue;
    }

    public void setPubEnvValue(String str) {
        this.mPubEnvValue = str;
    }

    public String getWalletSignLink() {
        return this.mWalletSignLink;
    }

    public void setWalletSignLink(String str) {
        this.mWalletSignLink = str;
    }

    public void setSampleId(String str) {
        this.mSampleId = str;
    }

    public String getSampleId() {
        return this.mSampleId;
    }

    public List<String> getHostWhiteList() {
        return this.mHostWhiteList;
    }

    public void setHostWhiteList(List<String> list) {
        this.mHostWhiteList = list;
    }

    public boolean needUploadMoreLog() {
        return SwitchManager.getInstance().findType("need_more_logs") == 1;
    }

    public boolean isPbPreloadSwitchOn() {
        return SwitchManager.getInstance().findType(PbPreloadSwitch.PB_PRELOAD_SWITCH_KEY) == 1;
    }

    public boolean isShowHomeFloatRefreshButton() {
        return this.mShowHomeFloatRefreshButton;
    }

    public boolean isShowShoubaiDynamicGuide() {
        return this.mShowShoubaiDynamicGuide;
    }

    public void setShowShoubaiDynamicGuide(boolean z) {
        this.mShowShoubaiDynamicGuide = z;
    }

    public void setCanWebViewActivityShowProgress(boolean z) {
        this.mCanWebViewActivityShowProgress = z;
    }

    public boolean isCanWebViewActivityShowProgress() {
        return this.mCanWebViewActivityShowProgress;
    }

    public boolean checkDistanceAccuracy(Context context) {
        if (!this.mDistanceAccuracyChecked) {
            this.mDistanceAccuracy = Math.abs(l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds1080)) < 50;
            this.mDistanceAccuracyChecked = true;
        }
        return this.mDistanceAccuracy;
    }

    public boolean isShowVivoBadge() {
        return this.mShowVivoBadge;
    }

    public void setSharePanelConfData(ad adVar) {
        this.mSharePanelConfData = adVar;
    }

    public ad getSharePanelConfData() {
        return this.mSharePanelConfData;
    }

    public String getVideoTestType() {
        return this.videoTestType;
    }

    public void setVideoTestType(String str) {
        this.videoTestType = str;
    }

    public void setPcdnConfigData(JSONObject jSONObject) {
        if (this.mPcdnConfigData == null) {
            this.mPcdnConfigData = new a();
        }
        this.mPcdnConfigData.dY(jSONObject);
    }

    public a getPcdnConfigData() {
        return this.mPcdnConfigData;
    }

    public void setClipboardDelayTime(boolean z) {
        this.mClipboardDelayTime = z;
    }

    public boolean getClipboardDelayTime() {
        return this.mClipboardDelayTime;
    }

    public NewGodData getNewGodData() {
        return this.mNewGodData;
    }

    public void setNewGodData(NewGodData newGodData) {
        this.mNewGodData = newGodData;
    }

    public void setMercatorData(MercatorModel.MercatorData mercatorData) {
        this.mMercatorData = mercatorData;
    }

    public MercatorModel.MercatorData getMercatorData() {
        return this.mMercatorData;
    }

    public void setPbToHomeUpdateData(ba baVar) {
        this.mPbToHomeUpdateData = baVar;
    }

    public ba getPbToHomeUpdateData() {
        return this.mPbToHomeUpdateData;
    }

    public int getFrsCurTabType() {
        return this.mFrsCurTabType;
    }

    public void setFrsCurTabType(int i) {
        this.mFrsCurTabType = i;
    }

    public void setForceRefreshHomeRecommend(boolean z) {
        this.mForceRefreshHomeRecommend = z;
    }

    public boolean getForceRefreshHomeRecommend() {
        return this.mForceRefreshHomeRecommend;
    }

    public void setNewUserRedPackageData(NewUserRedPackageData newUserRedPackageData) {
        this.mNewUserRedPackageData = newUserRedPackageData;
    }

    public NewUserRedPackageData getNewUserRedPackageData() {
        return this.mNewUserRedPackageData;
    }

    public b getChannelConfigModel() {
        return this.mChannelConfigModel;
    }

    public void setChannelConfigModel(b bVar) {
        this.mChannelConfigModel = bVar;
    }
}
