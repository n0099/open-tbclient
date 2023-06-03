package com.baidu.searchbox.player.utils;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class BdVolumeUtils {
    @Nullable
    public static AudioManager getAudioManager(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (AudioManager) context.getSystemService("audio");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getMaxVolume(Context context) {
        AudioManager audioManager = getAudioManager(context);
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return -1;
    }

    public static int getVolume(Context context) {
        AudioManager audioManager = getAudioManager(context);
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    public static float getVolumePercent(@Nullable Context context) {
        AudioManager audioManager = getAudioManager(context);
        if (audioManager != null) {
            return Math.round((audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3)) * 1000.0f) / 1000.0f;
        }
        return 0.0f;
    }

    public static boolean isMusicActive(@Nullable Context context) {
        AudioManager audioManager = getAudioManager(context);
        if (audioManager != null && audioManager.isMusicActive()) {
            return true;
        }
        return false;
    }

    public static void setVolume(Context context, int i) {
        AudioManager audioManager = getAudioManager(context);
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 8);
        }
    }

    public static void setVolumePercent(Context context, float f) {
        AudioManager audioManager = getAudioManager(context);
        if (audioManager != null) {
            audioManager.setStreamVolume(3, Math.round(audioManager.getStreamMaxVolume(3) * f), 0);
        }
    }
}
