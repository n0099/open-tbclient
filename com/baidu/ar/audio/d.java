package com.baidu.ar.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
/* loaded from: classes3.dex */
class d {
    private static boolean a() {
        AudioRecord audioRecord = new AudioRecord(1, 44100, 16, 2, 10240);
        try {
            audioRecord.startRecording();
            if (audioRecord.getRecordingState() != 3) {
                return false;
            }
            audioRecord.stop();
            audioRecord.release();
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? a(context, context.getApplicationContext().getPackageName()) : a();
    }

    private static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission("android.permission.RECORD_AUDIO", str) == 0;
    }
}
