package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a {
    private static b aaE;
    private static String aaF;
    private static g aaG;
    private static int aaD = 0;
    private static long aaH = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.aaG != null) {
                        a.aaG.m(a.aaF, message.arg1);
                        g unused = a.aaG = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.aaG != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.aaG.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.aaG.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.aaG = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.aaG != null) {
                        a.aaG.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.aaG = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.aaG != null) {
                        a.aaG.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.aaG != null) {
                        a.aaG.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.aaG = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.aaG != null) {
                        a.aaG.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.aaG = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.aaG != null) {
                        a.aaG.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.aaG = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.aaG != null) {
                        a.aaG.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.aaG = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.aaG != null) {
                        a.aaG.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.aaG != null) {
                        a.aaG.ot();
                        break;
                    }
                    break;
                default:
                    if (a.aaG != null) {
                        a.aaG.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.aaG = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.aaD = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - aaH < 1000) {
            return false;
        }
        aaH = System.currentTimeMillis();
        if (aaD == 0) {
            if (aaE == null) {
                aaE = new b(mHandler);
            }
            aaF = str;
            aaG = gVar;
            if (aaE.q(str, i)) {
                aaD = 3;
                new Thread(aaE).start();
                return true;
            }
            aaE = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (aaE != null) {
            aaE.stop();
        }
        aaD = 0;
    }

    public static void cancel() {
        if (aaE != null) {
            aaE.cancel();
        }
        aaD = 0;
    }
}
