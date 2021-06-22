package com.baidu.pass.face.platform.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.utils.SoundPlayer;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class SoundPoolHelper {
    public static final String TAG = "SoundPoolHelper";
    public Context mContext;
    public FaceStatusNewEnum mPlaySoundStatusNewEnum;
    public volatile long mPlayDuration = 0;
    public volatile long mPlayTime = 0;
    public volatile boolean mIsPlaying = false;
    public volatile boolean mIsEnableSound = true;
    public HashMap<Integer, Long> mPlayDurationMap = new HashMap<>();

    public SoundPoolHelper(Context context) {
        this.mContext = context;
    }

    private long getSoundDuration(int i2) {
        long j;
        if (this.mPlayDurationMap.containsKey(Integer.valueOf(i2))) {
            return this.mPlayDurationMap.get(Integer.valueOf(i2)).longValue();
        }
        System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i2));
            j = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
            try {
                this.mPlayDurationMap.put(Integer.valueOf(i2), Long.valueOf(j));
                return j;
            } catch (IllegalArgumentException e2) {
                e = e2;
                e.printStackTrace();
                return j;
            } catch (IllegalStateException e3) {
                e = e3;
                e.printStackTrace();
                return j;
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return j;
            }
        } catch (IllegalArgumentException e5) {
            e = e5;
            j = 600;
        } catch (IllegalStateException e6) {
            e = e6;
            j = 600;
        } catch (Exception e7) {
            e = e7;
            j = 600;
        }
    }

    public boolean getEnableSound() {
        return this.mIsEnableSound;
    }

    public long getPlayDuration() {
        return this.mPlayDuration;
    }

    public boolean playSound(FaceStatusNewEnum faceStatusNewEnum) {
        if (!this.mIsEnableSound) {
            SoundPlayer.release();
        }
        this.mIsPlaying = System.currentTimeMillis() - SoundPlayer.playTime < this.mPlayDuration;
        if (this.mIsPlaying || (this.mPlaySoundStatusNewEnum == faceStatusNewEnum && System.currentTimeMillis() - this.mPlayTime < FaceEnvironment.TIME_TIPS_REPEAT)) {
            return false;
        }
        this.mIsPlaying = true;
        this.mPlaySoundStatusNewEnum = faceStatusNewEnum;
        this.mPlayDuration = 0L;
        this.mPlayTime = System.currentTimeMillis();
        int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
        if (soundId > 0) {
            this.mPlayDuration = getSoundDuration(soundId);
            SoundPlayer.playTime = System.currentTimeMillis();
            if (this.mIsEnableSound) {
                SoundPlayer.play(this.mContext, soundId);
            }
        }
        return this.mIsPlaying;
    }

    public void release() {
        SoundPlayer.release();
        this.mPlayDuration = 0L;
        this.mPlayTime = 0L;
        this.mContext = null;
    }

    public void setEnableSound(boolean z) {
        this.mIsEnableSound = z;
    }
}
