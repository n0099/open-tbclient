package com.baidu.android.util.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.os.Build;
import android.util.SparseIntArray;
/* loaded from: classes19.dex */
public class SoundPlayer {
    private static final long LOAD_SOUND_MILLIS = 100;
    private static final int MAX_STREAMS = 5;
    private static final String TAG = "SoundPlayer";
    private static SoundPlayer sSoundPlayer;
    private SoundPool mSoundPool = new SoundPool(5, 3, 0);
    private SparseIntArray mSoundPoolCache = new SparseIntArray();

    @SuppressLint({"NewApi"})
    public void play(Context context, int i) {
        if (sSoundPlayer == null) {
            sSoundPlayer = new SoundPlayer();
        }
        int i2 = sSoundPlayer.mSoundPoolCache.get(i);
        if (i2 == 0) {
            final int load = sSoundPlayer.mSoundPool.load(context, i, 1);
            sSoundPlayer.mSoundPoolCache.put(i, load);
            if (Build.VERSION.SDK_INT >= 8) {
                sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.baidu.android.util.media.SoundPlayer.1
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public void onLoadComplete(SoundPool soundPool, int i3, int i4) {
                        if (i4 == 0 && load == i3) {
                            try {
                                SoundPlayer.sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                            } catch (NullPointerException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            try {
                Thread.currentThread().join(LOAD_SOUND_MILLIS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
            return;
        }
        sSoundPlayer.mSoundPool.play(i2, 1.0f, 1.0f, 5, 0, 1.0f);
    }

    public static void release() {
        if (sSoundPlayer != null) {
            int size = sSoundPlayer.mSoundPoolCache.size();
            for (int i = 0; i < size; i++) {
                sSoundPlayer.mSoundPool.unload(sSoundPlayer.mSoundPoolCache.valueAt(i));
            }
            sSoundPlayer.mSoundPool.release();
            sSoundPlayer.mSoundPool = null;
            sSoundPlayer.mSoundPoolCache.clear();
            sSoundPlayer.mSoundPoolCache = null;
            sSoundPlayer = null;
        }
    }
}
