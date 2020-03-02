package com.baidu.tbadk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.d.a;
import com.baidu.tbadk.switchs.PbPreloadSwitch;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public final class TbSingleton {
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_010 = 2;
    public static final int HOME_PAGE_STYLE_AB_TEST_100 = 4;
    private boolean isRecommendPage;
    private List<String> mHostWhiteList;
    private String mHotSearch;
    private boolean mIsOpenTrack;
    private boolean mIsPbFold;
    private boolean mIsShowPersonCenterLiteGame;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mProfileGameCenterKey;
    private String mPubEnvValue;
    private String mSampleId;
    private x mSharePanelConfData;
    private String mSharePanelText;
    private boolean mShowHomeFloatRefreshButton;
    private boolean mShowShoubaiDynamicGuide;
    private boolean mShowVivoBadge;
    private LinkedList<a> mVideoWatchTimeRecord;
    private String mWalletSignLink;
    private String videoTestType;
    private static TbSingleton mInstance = null;
    private static int VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE = 2;
    private static int VIDEO_ENTER_TYPE_NO_JUMP_VIDEO_MIDDLE_PAGE = 1;
    public static int NEW_VIDEO_CLICK_TEST_SWITCH_OFF = 0;
    public static int NEW_VIDEO_CLICK_TEST_ENTER_MIDDLE_PAGE = 1;
    public static int NEW_VIDEO_CLICK_TEST_ENTER_PB = 2;
    public ArrayList<String> testUrls = new ArrayList<>();
    private long pushDialogLoopTime = aq.MS_TO_HOUR;
    private long pushDialogShowTime = 5 * aq.MS_TO_MIN;
    private long lastResumeTime = 0;
    private boolean canShowPermDlg = false;
    private boolean hasShowPermDlg = false;
    private boolean isNewUser = false;
    private boolean mHasAgreeToPlay = false;
    private w mShakeData = null;
    private String invokeSource = "";
    private boolean mFrsRootViewLoadingShow = false;
    private boolean mFrsContentViewLoadingShow = false;
    private boolean isVideoEnterMiddlePage = true;
    private int mNewVideoClickType = NEW_VIDEO_CLICK_TEST_SWITCH_OFF;
    private boolean mIsVideoCardMute = true;
    private boolean mIsVideoCardMuteInHeadSet = false;
    private boolean mEnableBenchmark = false;
    private int mCpuFlopsDur = -1;
    private int mCpuThreshold = Integer.MAX_VALUE;
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
        setIsOpenTrack(b.aFD().getBoolean("key_is_open_track", false));
        setProfileGameCenterKey(b.aFD().getString("profile_swan_app_key", ""));
        setHomePageStyleAbTest(b.aFD().getInt("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(b.aFD().getString("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(b.aFD().getString("index_activity_abtest_url", ""));
        setShowPersonCenterLiteGame(b.aFD().getBoolean("person_center_show_lite_game", true));
        setIsPbFold(b.aFD().getBoolean("pb_fold_small_flow_json", false));
        setVideoEnterMiddlePage(b.aFD().getInt("key_video_play_type", VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE));
        setNewVideoClickType(b.aFD().getInt("key_video_click_test", NEW_VIDEO_CLICK_TEST_SWITCH_OFF));
        setUbsSampleId(b.aFD().getString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), ""));
        setShowShoubaiDynamicGuide(b.aFD().getInt("key_is_show_shoubai_dynamic_guide", 0) == 1);
        this.mShowHomeFloatRefreshButton = b.aFD().getInt("key_home_refresh_button_test", 0) == 1;
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        e.gx().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.1
            @Override // java.lang.Runnable
            public void run() {
                TbSingleton.this.registerScreenSizeChangeTask();
            }
        });
        this.mShowVivoBadge = b.aFD().getBoolean("key_show_vivo_badge", false);
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
        a aVar;
        boolean z;
        if (!aq.isEmpty(str)) {
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
            a aVar2 = new a(str, i);
            if (size >= 10) {
                this.mVideoWatchTimeRecord.pollFirst();
                this.mVideoWatchTimeRecord.addLast(aVar2);
                return;
            }
            this.mVideoWatchTimeRecord.addLast(aVar2);
        }
    }

    public LinkedList<a> getVideoRecordList() {
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
        return this.canShowPermDlg && !this.hasShowPermDlg;
    }

    public void setHasShowPermDlg(boolean z) {
        this.hasShowPermDlg = z;
    }

    public void setCanShowPermDlg(boolean z) {
        this.canShowPermDlg = z;
    }

    public long getLastResumeTime() {
        if (this.lastResumeTime == 0) {
            this.lastResumeTime = b.aFD().getLong("last_resume_time", 0L);
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

    public void setVideoEnterMiddlePage(int i) {
        if (i == VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE) {
            this.isVideoEnterMiddlePage = true;
        } else if (i == VIDEO_ENTER_TYPE_NO_JUMP_VIDEO_MIDDLE_PAGE) {
            this.isVideoEnterMiddlePage = false;
        }
    }

    public boolean isVideoEnterMiddlePage() {
        return this.isVideoEnterMiddlePage;
    }

    private void setNewVideoClickType(int i) {
        this.mNewVideoClickType = i;
    }

    public int getNewVideoClickType() {
        return this.mNewVideoClickType;
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
        this.mEnableBenchmark = b.aFD().getBoolean("enable_benchmark", true);
        this.mCpuThreshold = b.aFD().getInt("cpu_flops_dura_threshold", Integer.MAX_VALUE);
        this.mAnimFpsSyncThreshold = b.aFD().getInt("anim_avg_fps_threshold", 0);
    }

    public boolean isAnimFpsComputed(String str) {
        return !aq.isEmpty(str) && getAnimComputedFps(str) >= 0;
    }

    public int getAnimComputedFps(String str) {
        if (aq.isEmpty(str)) {
            return -1;
        }
        return b.aFD().getInt(str, -1);
    }

    public void setAnimComputedFps(String str, int i) {
        if (!aq.isEmpty(str)) {
            b.aFD().putInt(str, i);
            if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
                setSlideAnimLocalSwitch(false);
            }
        }
    }

    public Integer getAnimAvgFps(String str) {
        if (aq.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(b.aFD().getInt(str + "_anim_benchmark_avg_suffix", 0));
    }

    public void setAnimAvgFps(String str, int i) {
        if (!aq.isEmpty(str) && i >= 0) {
            b.aFD().putInt(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public Integer getAnimAvgFpsCount(String str) {
        if (aq.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(b.aFD().getInt(str + "_anim_benchmark_times_suffix", 0));
    }

    public void setAnimAvgFpsCount(String str, int i) {
        if (!aq.isEmpty(str) && i >= 0) {
            b.aFD().putInt(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        b.aFD().putBoolean("local_slide_animation__switch", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
    }

    public boolean isSlideAnimLocalSwitchOn() {
        return b.aFD().getBoolean("local_slide_animation__switch", false);
    }

    public boolean isSlideAnimEnable() {
        boolean z = b.aFD().getInt("slide_local_switch_is_clicked", 0) == 1;
        boolean z2 = b.aFD().getInt("sync_slide_animation__switch", 0) == 1;
        boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
        if (z) {
            return isSlideAnimLocalSwitchOn;
        }
        if (z2 != isSlideAnimLocalSwitchOn) {
            b.aFD().putBoolean("local_slide_animation__switch", z2);
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
            this.mCpuFlopsDur = b.aFD().getInt("cpu_flops_dura", 0);
        }
        return this.mCpuFlopsDur;
    }

    public void setCpuFlopsDuration(int i) {
        if (i >= 0) {
            this.mCpuFlopsDur = i;
            b.aFD().putInt("cpu_flops_dura", i);
        }
    }

    public void setEnableBenchmark(boolean z) {
        this.mEnableBenchmark = z;
        b.aFD().putBoolean("enable_benchmark", z);
    }

    public boolean isEnableBenchmark() {
        return this.mEnableBenchmark;
    }

    public void setCpuThreshold(int i) {
        this.mCpuThreshold = i;
        b.aFD().putInt("cpu_flops_dura_threshold", i);
    }

    public void setAnimAverageFpsThreshold(int i) {
        this.mAnimFpsSyncThreshold = i;
        b.aFD().putInt("anim_avg_fps_threshold", i);
    }

    public int getCpuFlopsDurationSyncThreshold() {
        return this.mCpuThreshold;
    }

    public int getAnimFpsSyncThreshold() {
        return this.mAnimFpsSyncThreshold;
    }

    public void setShakeData(w wVar) {
        this.mShakeData = wVar;
    }

    public w getShakeData() {
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

    public void setIsPbFold(boolean z) {
        this.mIsPbFold = z;
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

    public int getHomePageStyleAbTest() {
        return this.mHomePageStyleAbTest;
    }

    public void setHomePageStyleAbTest(int i) {
        this.mHomePageStyleAbTest = i;
    }

    private void setUbsSampleId(String str) {
        this.mSampleId = str;
    }

    public boolean isPbFold() {
        return this.mIsPbFold;
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
            TiebaStatic.log(new an("c13274").cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_id", "15471320").cy("obj_source", "game_lauch_screen").cy("obj_name", "可口大冒险").X("obj_param1", 1));
        }
    }

    public void registerScreenSizeChangeTask() {
        e.gx().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.3
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

    public void setSharePanelConfData(x xVar) {
        this.mSharePanelConfData = xVar;
    }

    public x getSharePanelConfData() {
        return this.mSharePanelConfData;
    }

    public String getVideoTestType() {
        return this.videoTestType;
    }

    public void setVideoTestType(String str) {
        this.videoTestType = str;
    }
}
