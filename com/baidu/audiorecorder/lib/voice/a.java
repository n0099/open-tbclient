package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b KG;
    private static String KH;
    private static com.baidu.adp.lib.voice.g KI;
    private static int KF = 0;
    private static long KJ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.KI != null) {
                        a.KI.k(a.KH, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.KI = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.KI != null) {
                        if (com.baidu.adp.lib.util.e.hb()) {
                            a.KI.f(message.what, h.getString(d.l.voice_err_create_file_fail));
                        } else {
                            a.KI.f(message.what, h.getString(d.l.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.KI = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.KI != null) {
                        a.KI.f(message.what, h.getString(d.l.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.KI = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.KI != null) {
                        a.KI.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.KI != null) {
                        a.KI.f(message.what, h.getString(d.l.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.KI = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.KI != null) {
                        a.KI.f(message.what, h.getString(d.l.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.KI = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.KI != null) {
                        a.KI.f(message.what, h.getString(d.l.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.KI = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.KI != null) {
                        a.KI.f(message.what, h.getString(d.l.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.KI = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.KI != null) {
                        a.KI.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.KI != null) {
                        a.KI.hV();
                        break;
                    }
                    break;
                default:
                    if (a.KI != null) {
                        a.KI.f(message.what, h.getString(d.l.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.KI = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.KF = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - KJ < 1000) {
            return false;
        }
        KJ = System.currentTimeMillis();
        if (KF == 0) {
            if (KG == null) {
                KG = new b(mHandler);
            }
            KH = str;
            KI = gVar;
            if (KG.o(str, i)) {
                KF = 3;
                new Thread(KG).start();
                return true;
            }
            KG = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (KG != null) {
            KG.stop();
        }
        KF = 0;
    }

    public static void cancel() {
        if (KG != null) {
            KG.cancel();
        }
        KF = 0;
    }
}
