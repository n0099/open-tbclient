package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a {
    private static b aaD;
    private static String aaE;
    private static g aaF;
    private static int aaC = 0;
    private static long aaG = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.aaF != null) {
                        a.aaF.m(a.aaE, message.arg1);
                        g unused = a.aaF = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.aaF != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.aaF.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.aaF.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.aaF = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.aaF != null) {
                        a.aaF.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.aaF = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.aaF != null) {
                        a.aaF.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.aaF != null) {
                        a.aaF.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.aaF = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.aaF != null) {
                        a.aaF.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.aaF = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.aaF != null) {
                        a.aaF.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.aaF = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.aaF != null) {
                        a.aaF.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.aaF = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.aaF != null) {
                        a.aaF.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.aaF != null) {
                        a.aaF.ot();
                        break;
                    }
                    break;
                default:
                    if (a.aaF != null) {
                        a.aaF.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.aaF = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.aaC = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - aaG < 1000) {
            return false;
        }
        aaG = System.currentTimeMillis();
        if (aaC == 0) {
            if (aaD == null) {
                aaD = new b(mHandler);
            }
            aaE = str;
            aaF = gVar;
            if (aaD.q(str, i)) {
                aaC = 3;
                new Thread(aaD).start();
                return true;
            }
            aaD = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (aaD != null) {
            aaD.stop();
        }
        aaC = 0;
    }

    public static void cancel() {
        if (aaD != null) {
            aaD.cancel();
        }
        aaC = 0;
    }
}
