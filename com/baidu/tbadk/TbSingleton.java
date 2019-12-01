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
import com.baidu.adp.lib.b.d;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class TbSingleton {
    public static final int HOME_PAGE_STYLE_AB_TEST_001 = 1;
    public static final int HOME_PAGE_STYLE_AB_TEST_010 = 2;
    public static final int HOME_PAGE_STYLE_AB_TEST_100 = 4;
    private boolean isRecommendPage;
    private String mHotSearch;
    private boolean mIsPbFold;
    private boolean mIsShowPersonCenterLiteGame;
    private String mMissionEntranceIcon;
    private String mMissionEntranceUrl;
    private String mProfileGameCenterKey;
    private String mSampleId;
    private String mSharePanelText;
    private LinkedList<a> mVideoWatchTimeRecord;
    private static TbSingleton mInstance = null;
    private static int VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE = 2;
    private static int VIDEO_ENTER_TYPE_NO_JUMP_VIDEO_MIDDLE_PAGE = 1;
    public ArrayList<String> testUrls = new ArrayList<>();
    private long pushDialogLoopTime = aq.MS_TO_HOUR;
    private long pushDialogShowTime = 5 * aq.MS_TO_MIN;
    private long lastResumeTime = 0;
    private boolean canShowPermDlg = false;
    private boolean hasShowPermDlg = false;
    private boolean isNewUser = false;
    private boolean mHasAgreeToPlay = false;
    private v mShakeData = null;
    private String invokeSource = "";
    private boolean mFrsRootViewLoadingShow = false;
    private boolean mFrsContentViewLoadingShow = false;
    private boolean hasAgreeSecretProtocol = false;
    private boolean isVideoEnterMiddlePage = true;
    private boolean mIsVideoCardMute = true;
    private boolean mIsVideoCardMuteInHeadSet = false;
    private boolean mEnableBenchmark = false;
    private int mCpuFlopsDur = -1;
    private int mCpuThreshold = Integer.MAX_VALUE;
    private int mAnimFpsSyncThreshold = 0;
    private int mIsNotchScreen = -1;
    private int mIsCutoutScreen = -1;
    public boolean mStartGameClicked = false;
    private boolean hasDownloadEmotion = false;
    private int mHomePageStyleAbTest = 0;
    private HashMap<Long, String> liveForumMap = new HashMap<>();
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
        setProfileGameCenterKey(b.alP().getString("profile_swan_app_key", ""));
        setHomePageStyleAbTest(b.alP().getInt("index_activity_abtest_switch_json", 0));
        setMissionEntranceIcon(b.alP().getString("index_activity_abtest_icon_url", ""));
        setMissionEntranceUrl(b.alP().getString("index_activity_abtest_url", ""));
        setShowPersonCenterLiteGame(b.alP().getBoolean("person_center_show_lite_game", true));
        setIsPbFold(b.alP().getBoolean("pb_fold_small_flow_json", false));
        setVideoEnterMiddlePage(b.alP().getInt("key_video_play_type", VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE));
        setUbsSampleId(b.alP().getString("key_ubs_sample_id" + TbadkCoreApplication.getCurrentAccount(), ""));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
        e.fZ().post(new Runnable() { // from class: com.baidu.tbadk.TbSingleton.1
            @Override // java.lang.Runnable
            public void run() {
                TbSingleton.this.registerScreenSizeChangeTask();
            }
        });
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
            this.lastResumeTime = b.alP().getLong("last_resume_time", 0L);
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
        this.mEnableBenchmark = b.alP().getBoolean("enable_benchmark", true);
        this.mCpuThreshold = b.alP().getInt("cpu_flops_dura_threshold", Integer.MAX_VALUE);
        this.mAnimFpsSyncThreshold = b.alP().getInt("anim_avg_fps_threshold", 0);
    }

    public boolean isAnimFpsComputed(String str) {
        return !aq.isEmpty(str) && getAnimComputedFps(str) >= 0;
    }

    public int getAnimComputedFps(String str) {
        if (aq.isEmpty(str)) {
            return -1;
        }
        return b.alP().getInt(str, -1);
    }

    public void setAnimComputedFps(String str, int i) {
        if (!aq.isEmpty(str)) {
            b.alP().putInt(str, i);
            if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
                setSlideAnimLocalSwitch(false);
            }
        }
    }

    public Integer getAnimAvgFps(String str) {
        if (aq.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(b.alP().getInt(str + "_anim_benchmark_avg_suffix", 0));
    }

    public void setAnimAvgFps(String str, int i) {
        if (!aq.isEmpty(str) && i >= 0) {
            b.alP().putInt(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public Integer getAnimAvgFpsCount(String str) {
        if (aq.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(b.alP().getInt(str + "_anim_benchmark_times_suffix", 0));
    }

    public void setAnimAvgFpsCount(String str, int i) {
        if (!aq.isEmpty(str) && i >= 0) {
            b.alP().putInt(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        b.alP().putBoolean("local_slide_animation__switch", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
    }

    public boolean isSlideAnimLocalSwitchOn() {
        return b.alP().getBoolean("local_slide_animation__switch", false);
    }

    public boolean isSlideAnimEnable() {
        boolean z = b.alP().getInt("slide_local_switch_is_clicked", 0) == 1;
        boolean z2 = b.alP().getInt("sync_slide_animation__switch", 0) == 1;
        boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
        if (z) {
            return isSlideAnimLocalSwitchOn;
        }
        if (z2 != isSlideAnimLocalSwitchOn) {
            b.alP().putBoolean("local_slide_animation__switch", z2);
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
            this.mCpuFlopsDur = b.alP().getInt("cpu_flops_dura", 0);
        }
        return this.mCpuFlopsDur;
    }

    public void setCpuFlopsDuration(int i) {
        if (i >= 0) {
            this.mCpuFlopsDur = i;
            b.alP().putInt("cpu_flops_dura", i);
        }
    }

    public void setEnableBenchmark(boolean z) {
        this.mEnableBenchmark = z;
        b.alP().putBoolean("enable_benchmark", z);
    }

    public boolean isEnableBenchmark() {
        return this.mEnableBenchmark;
    }

    public void setCpuThreshold(int i) {
        this.mCpuThreshold = i;
        b.alP().putInt("cpu_flops_dura_threshold", i);
    }

    public void setAnimAverageFpsThreshold(int i) {
        this.mAnimFpsSyncThreshold = i;
        b.alP().putInt("anim_avg_fps_threshold", i);
    }

    public int getCpuFlopsDurationSyncThreshold() {
        return this.mCpuThreshold;
    }

    public int getAnimFpsSyncThreshold() {
        return this.mAnimFpsSyncThreshold;
    }

    public void setShakeData(v vVar) {
        this.mShakeData = vVar;
    }

    public v getShakeData() {
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
            TiebaStatic.log(new an("c13274").bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_id", "15471320").bS("obj_source", "game_lauch_screen").bS("obj_name", "可口大冒险").O("obj_param1", 1));
        }
    }

    public void registerScreenSizeChangeTask() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921414, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tbadk.TbSingleton.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2921414);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void setSampleId(String str) {
        this.mSampleId = str;
    }

    public String getSampleId() {
        return this.mSampleId;
    }

    public boolean needUploadMoreLog() {
        return d.ft().af("need_more_logs") == 1;
    }

    public void setHasAgreeSecretProtocol(boolean z) {
        this.hasAgreeSecretProtocol = z;
    }

    public boolean hasAgreeSecretProtocol() {
        return this.hasAgreeSecretProtocol;
    }
}
