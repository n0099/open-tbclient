package com.baidu.cyberplayer.sdk;

import com.baidu.cyberplayer.sdk.ab.CyberAbTestManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
/* loaded from: classes3.dex */
public class MediaPlayerReduceHelper {
    public static final String TAG = "MpReduce";
    public long mMediaStartPrepareTs = -1;
    public boolean mIsMediaPlayerFirstDisp = false;
    public long mMediaPlayerPlayDuration = 0;

    public static boolean isMpReduceEnable() {
        int abSwitchInt = CyberAbTestManager.getAbSwitchInt("media_player_reduce_enable", 0);
        CyberLog.d(TAG, "isMpReduceEnable: " + abSwitchInt);
        if (abSwitchInt != 1) {
            return false;
        }
        return true;
    }

    public long getMediaPlayerPlayDuration() {
        return this.mMediaPlayerPlayDuration;
    }

    public boolean isMediaPlayerFirstDisp() {
        return this.mIsMediaPlayerFirstDisp;
    }

    public void reset() {
        this.mMediaStartPrepareTs = -1L;
        this.mIsMediaPlayerFirstDisp = false;
        this.mMediaPlayerPlayDuration = 0L;
    }

    public void setIsMediaPlayerFirstDisp(boolean z) {
        this.mIsMediaPlayerFirstDisp = z;
    }

    public void setMediaPlayerPrepareTs(long j) {
        this.mMediaStartPrepareTs = j;
    }

    public boolean shouldSwitchToCyberPlayer() {
        if (!isMpReduceEnable()) {
            CyberLog.d(TAG, "shouldSwitchToCyberPlayer, ab disable!");
            return false;
        } else if (this.mMediaStartPrepareTs <= 0) {
            CyberLog.d(TAG, "shouldSwitchToCyberPlayer, sMediaStartPrepareTs invalid, do not switch!!");
            return false;
        } else if (this.mIsMediaPlayerFirstDisp) {
            CyberLog.d(TAG, "shouldSwitchToCyberPlayer, MediaPlayer has already first disp!!");
            return false;
        } else {
            int cfgIntValue = CyberCfgManager.getInstance().getCfgIntValue("media_player_switch_threshold", 1814);
            this.mMediaPlayerPlayDuration = System.currentTimeMillis() - this.mMediaStartPrepareTs;
            CyberLog.d(TAG, "shouldSwitchToCyberPlayer, playDur: " + this.mMediaPlayerPlayDuration + ", threshold: " + cfgIntValue);
            if (this.mMediaPlayerPlayDuration > cfgIntValue) {
                return false;
            }
            CyberLog.d(TAG, "shouldSwitchToCyberPlayer, prepare to switch to cyber");
            return true;
        }
    }
}
