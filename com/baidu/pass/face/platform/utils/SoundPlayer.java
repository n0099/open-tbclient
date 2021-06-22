package com.baidu.pass.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;
/* loaded from: classes2.dex */
public final class SoundPlayer {
    public static final boolean DEBUG = false;
    public static final long LOAD_SOUND_MILLIS = 100;
    public static final int MAX_STREAMS = 5;
    public static final String TAG = "SoundPlayer";
    public static long playTime;
    public static SoundPlayer sSoundPlayer;
    public SoundPool mSoundPool = new SoundPool(5, 3, 0);
    public SparseIntArray mSoundPoolCache = new SparseIntArray();

    public SoundPlayer() {
        playTime = 0L;
    }

    @SuppressLint({"NewApi"})
    public static void play(Context context, int i2) {
        if (sSoundPlayer == null) {
            sSoundPlayer = new SoundPlayer();
        }
        int i3 = sSoundPlayer.mSoundPoolCache.get(i2);
        if (i3 == 0) {
            final int load = sSoundPlayer.mSoundPool.load(context, i2, 1);
            sSoundPlayer.mSoundPoolCache.put(i2, load);
            if (APIUtils.hasFroyo()) {
                sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.baidu.pass.face.platform.utils.SoundPlayer.1
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public void onLoadComplete(SoundPool soundPool, int i4, int i5) {
                        if (i5 == 0 && load == i4) {
                            try {
                                SoundPlayer.playTime = System.currentTimeMillis();
                                SoundPlayer.sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            try {
                Thread.currentThread().join(100L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            playTime = System.currentTimeMillis();
            sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
            return;
        }
        try {
            sSoundPlayer.mSoundPool.play(i3, 1.0f, 1.0f, 5, 0, 1.0f);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void release() {
        SoundPlayer soundPlayer = sSoundPlayer;
        if (soundPlayer != null) {
            int size = soundPlayer.mSoundPoolCache.size();
            for (int i2 = 0; i2 < size; i2++) {
                SoundPlayer soundPlayer2 = sSoundPlayer;
                soundPlayer2.mSoundPool.unload(soundPlayer2.mSoundPoolCache.valueAt(i2));
            }
            sSoundPlayer.mSoundPool.release();
            SoundPlayer soundPlayer3 = sSoundPlayer;
            soundPlayer3.mSoundPool = null;
            soundPlayer3.mSoundPoolCache.clear();
            sSoundPlayer.mSoundPoolCache = null;
            sSoundPlayer = null;
        }
        playTime = 0L;
    }
}
