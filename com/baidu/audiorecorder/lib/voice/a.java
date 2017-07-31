package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b KE;
    private static String KF;
    private static com.baidu.adp.lib.voice.g KG;
    private static int KD = 0;
    private static long KH = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.KG != null) {
                        a.KG.k(a.KF, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.KG = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.KG != null) {
                        if (com.baidu.adp.lib.util.e.hb()) {
                            a.KG.f(message.what, h.getString(d.l.voice_err_create_file_fail));
                        } else {
                            a.KG.f(message.what, h.getString(d.l.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.KG = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.KG != null) {
                        a.KG.f(message.what, h.getString(d.l.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.KG = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.KG != null) {
                        a.KG.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.KG != null) {
                        a.KG.f(message.what, h.getString(d.l.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.KG = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.KG != null) {
                        a.KG.f(message.what, h.getString(d.l.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.KG = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.KG != null) {
                        a.KG.f(message.what, h.getString(d.l.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.KG = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.KG != null) {
                        a.KG.f(message.what, h.getString(d.l.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.KG = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.KG != null) {
                        a.KG.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.KG != null) {
                        a.KG.hV();
                        break;
                    }
                    break;
                default:
                    if (a.KG != null) {
                        a.KG.f(message.what, h.getString(d.l.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.KG = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.KD = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - KH < 1000) {
            return false;
        }
        KH = System.currentTimeMillis();
        if (KD == 0) {
            if (KE == null) {
                KE = new b(mHandler);
            }
            KF = str;
            KG = gVar;
            if (KE.o(str, i)) {
                KD = 3;
                new Thread(KE).start();
                return true;
            }
            KE = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (KE != null) {
            KE.stop();
        }
        KD = 0;
    }

    public static void cancel() {
        if (KE != null) {
            KE.cancel();
        }
        KD = 0;
    }
}
