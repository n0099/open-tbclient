package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.d.a;
import java.util.LinkedList;
/* loaded from: classes.dex */
public final class TbSingleton {
    private boolean isRecommendPage;
    private String mHotSearch;
    private boolean mIsPbFold;
    private boolean mIsVideoCardMute;
    private boolean mIsVideoCardMuteInHeadSet;
    private String mSharePanelText;
    private LinkedList<a> mVideoWatchTimeRecord;
    private static TbSingleton mInstance = null;
    private static int VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE = 2;
    private static int VIDEO_ENTER_TYPE_NO_JUMP_VIDEO_MIDDLE_PAGE = 1;
    private long pushDialogLoopTime = ap.bKP;
    private long pushDialogShowTime = 5 * ap.bKO;
    private long lastResumeTime = 0;
    private boolean canShowPermDlg = false;
    private boolean hasShowPermDlg = false;
    private boolean isNewUser = false;
    private boolean mHasAgreeToPlay = false;
    private u mShakeData = null;
    private String invokeSource = "";
    private boolean mFrsRootViewLoadingShow = false;
    private boolean mFrsContentViewLoadingShow = false;
    private boolean isVideoEnterMiddlePage = true;
    private boolean mEnableBenchmark = false;
    private int mCpuFlopsDur = -1;
    private int mCpuThreshold = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int mAnimFpsSyncThreshold = 0;
    private final BroadcastReceiver mHeadSetStateReceiver = new BroadcastReceiver() { // from class: com.baidu.tbadk.TbSingleton.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra(WXLoginActivity.KEY_BASE_RESP_STATE)) {
                if (intent.getIntExtra(WXLoginActivity.KEY_BASE_RESP_STATE, 0) != 0 && intent.getIntExtra(WXLoginActivity.KEY_BASE_RESP_STATE, 0) == 1) {
                    z = true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921398, Boolean.valueOf(z)));
            }
        }
    };

    private TbSingleton() {
        this.mIsVideoCardMute = true;
        this.mIsVideoCardMuteInHeadSet = false;
        this.mIsVideoCardMute = b.getInstance().getBoolean("key_video_card_mute", true);
        this.mIsVideoCardMuteInHeadSet = b.getInstance().getBoolean("key_video_card_mute_in_headset", false);
        setIsPbFold(b.getInstance().getBoolean("pb_fold_small_flow_json", false));
        setVideoEnterMiddlePage(b.getInstance().getInt("key_video_play_type", VIDEO_ENTER_TYPE_JUMP_VIDEO_MIDDLE_PAGE));
        initBenchmarkData();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        TbadkCoreApplication.getInst().registerReceiver(this.mHeadSetStateReceiver, intentFilter);
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
        if (!ap.isEmpty(str)) {
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
            this.lastResumeTime = b.getInstance().getLong("last_resume_time", 0L);
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
            b.getInstance().putBoolean("key_video_card_mute_in_headset", z);
            return;
        }
        this.mIsVideoCardMute = z;
        b.getInstance().putBoolean("key_video_card_mute", z);
    }

    public boolean isVideoCardMute() {
        return isHeadsetPlugged() ? this.mIsVideoCardMuteInHeadSet : this.mIsVideoCardMute;
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
        this.mEnableBenchmark = b.getInstance().getBoolean("enable_benchmark", true);
        this.mCpuThreshold = b.getInstance().getInt("cpu_flops_dura_threshold", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mAnimFpsSyncThreshold = b.getInstance().getInt("anim_avg_fps_threshold", 0);
    }

    public boolean isAnimFpsComputed(String str) {
        return !ap.isEmpty(str) && getAnimComputedFps(str) >= 0;
    }

    public int getAnimComputedFps(String str) {
        if (ap.isEmpty(str)) {
            return -1;
        }
        return b.getInstance().getInt(str, -1);
    }

    public void setAnimComputedFps(String str, int i) {
        if (!ap.isEmpty(str)) {
            b.getInstance().putInt(str, i);
            if ("anim_switch_slide".equals(str) && !isAnimEnable(str)) {
                setSlideAnimLocalSwitch(false);
            }
        }
    }

    public Integer getAnimAvgFps(String str) {
        if (ap.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(b.getInstance().getInt(str + "_anim_benchmark_avg_suffix", 0));
    }

    public void setAnimAvgFps(String str, int i) {
        if (!ap.isEmpty(str) && i >= 0) {
            b.getInstance().putInt(str + "_anim_benchmark_avg_suffix", i);
        }
    }

    public Integer getAnimAvgFpsCount(String str) {
        if (ap.isEmpty(str)) {
            return 0;
        }
        return Integer.valueOf(b.getInstance().getInt(str + "_anim_benchmark_times_suffix", 0));
    }

    public void setAnimAvgFpsCount(String str, int i) {
        if (!ap.isEmpty(str) && i >= 0) {
            b.getInstance().putInt(str + "_anim_benchmark_times_suffix", i);
        }
    }

    public void setSlideAnimLocalSwitch(boolean z) {
        b.getInstance().putBoolean("local_slide_animation__switch", z);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2156674, Boolean.valueOf(z)));
    }

    public boolean isSlideAnimLocalSwitchOn() {
        return b.getInstance().getBoolean("local_slide_animation__switch", false);
    }

    public boolean isSlideAnimEnable() {
        boolean z = b.getInstance().getInt("slide_local_switch_is_clicked", 0) == 1;
        boolean z2 = b.getInstance().getInt("sync_slide_animation__switch", 0) == 1;
        boolean isSlideAnimLocalSwitchOn = isSlideAnimLocalSwitchOn();
        if (z) {
            return isSlideAnimLocalSwitchOn;
        }
        if (z2 != isSlideAnimLocalSwitchOn) {
            b.getInstance().putBoolean("local_slide_animation__switch", z2);
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
            this.mCpuFlopsDur = b.getInstance().getInt("cpu_flops_dura", 0);
        }
        return this.mCpuFlopsDur;
    }

    public void setCpuFlopsDuration(int i) {
        if (i >= 0) {
            this.mCpuFlopsDur = i;
            b.getInstance().putInt("cpu_flops_dura", i);
        }
    }

    public void setEnableBenchmark(boolean z) {
        this.mEnableBenchmark = z;
        b.getInstance().putBoolean("enable_benchmark", z);
    }

    public boolean isEnableBenchmark() {
        return this.mEnableBenchmark;
    }

    public void setCpuThreshold(int i) {
        this.mCpuThreshold = i;
        b.getInstance().putInt("cpu_flops_dura_threshold", i);
    }

    public void setAnimAverageFpsThreshold(int i) {
        this.mAnimFpsSyncThreshold = i;
        b.getInstance().putInt("anim_avg_fps_threshold", i);
    }

    public int getCpuFlopsDurationSyncThreshold() {
        return this.mCpuThreshold;
    }

    public int getAnimFpsSyncThreshold() {
        return this.mAnimFpsSyncThreshold;
    }

    public void setShakeData(u uVar) {
        this.mShakeData = uVar;
    }

    public u getShakeData() {
        return this.mShakeData;
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

    public boolean isPbFold() {
        return this.mIsPbFold;
    }

    private boolean isHeadsetPlugged() {
        return ((AudioManager) TbadkCoreApplication.getInst().getSystemService("audio")).isWiredHeadsetOn();
    }
}
