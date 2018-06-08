package com.baidu.ar.util.sputil;

import android.content.Context;
/* loaded from: classes3.dex */
public class SPUtils {
    public static boolean getIsCaseFirstIn(Context context, String str) {
        return ARSharedPreference.getBoolean(context, str, true);
    }

    public static boolean getIsFirstShowGestureGuide(Context context, String str) {
        return ARSharedPreference.getBoolean(context, str, true);
    }

    public static boolean getIsShowRecordAudioTip(Context context, String str) {
        return ARSharedPreference.getBoolean(context, str, true);
    }

    public static int getIsShowRecordAudioTipCount(Context context, String str) {
        return ARSharedPreference.getInt(context, "audio_tip_show_count", 0);
    }

    public static boolean hasAudioDialogShown(Context context) {
        return ARSharedPreference.getBoolean(context, "audio_dialog_show", false);
    }

    public static boolean hasCameraSwitchTipShown(Context context) {
        return ARSharedPreference.getBoolean(context, "camera_switch_tip_show", false);
    }

    public static boolean isShowRecommendAnim(Context context) {
        return ARSharedPreference.getInt(context, "case_anim_sdk_launch_count", 0) < 3;
    }

    public static void putIsCaseFirstIn(Context context, String str, boolean z) {
        ARSharedPreference.putBoolean(context, str, z);
    }

    public static void putIsFirstShowGestureGuide(Context context, String str, boolean z) {
        ARSharedPreference.putBoolean(context, str, z);
    }

    public static void putIsShowRecordAudioTip(Context context, String str, boolean z) {
        ARSharedPreference.putBoolean(context, str, z);
    }

    public static void putIsShowRecordAudioTipCount(Context context, String str, int i) {
        ARSharedPreference.putInt(context, "audio_tip_show_count", i);
    }

    public static void saveShowRecommendAnim(Context context) {
        int i = ARSharedPreference.getInt(context, "case_anim_sdk_launch_count", 0) + 1;
        if (i <= 3) {
            ARSharedPreference.putInt(context, "case_anim_sdk_launch_count", i);
        }
    }

    public static void setAudioDialogShown(Context context) {
        ARSharedPreference.putBoolean(context, "audio_dialog_show", true);
    }

    public static void setCameraSwitchTipShown(Context context) {
        ARSharedPreference.putBoolean(context, "camera_switch_tip_show", true);
    }
}
