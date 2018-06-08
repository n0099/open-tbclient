package com.baidu.ar.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.util.Log;
/* loaded from: classes3.dex */
class b {
    private static final String a = b.class.getSimpleName();

    b() {
    }

    public static double a(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = SupportMenu.USER_MASK - i2;
            }
            d += Math.abs(i2);
        }
        return Math.log10(((d / bArr.length) / 2.0d) + 1.0d) * 10.0d;
    }

    private static boolean a() {
        boolean z;
        AudioRecord audioRecord = new AudioRecord(1, AudioParams.DEFAULT_SAMPLE_RATE, 16, 2, 640);
        try {
            audioRecord.startRecording();
            boolean z2 = audioRecord.getRecordingState() == 3;
            byte[] bArr = new byte[AudioParams.DEFAULT_AUDIO_BUFFER_SIZE];
            int i = 0;
            while (true) {
                if (i >= 20) {
                    z = z2;
                    break;
                }
                audioRecord.read(bArr, 0, bArr.length);
                double a2 = a(bArr);
                Log.i(a, "checkPermissionUnderVersionM volume = " + a2);
                z2 = a2 != 0.0d;
                if (z2) {
                    z = z2;
                    break;
                }
                i++;
            }
            audioRecord.stop();
            audioRecord.release();
            return z;
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

    public static double b(byte[] bArr) {
        double d = 0.0d;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = SupportMenu.USER_MASK - i2;
            }
            d += i2 * i2;
        }
        return Math.min(5000.0d, Math.sqrt((d / bArr.length) / 2.0d)) / 50.0d;
    }
}
