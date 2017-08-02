package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b Jg;
    private static String Jh;
    private static com.baidu.adp.lib.voice.g Ji;
    private static int Jf = 0;
    private static long Jj = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Ji != null) {
                        a.Ji.k(a.Jh, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.Ji = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Ji != null) {
                        if (com.baidu.adp.lib.util.e.gR()) {
                            a.Ji.f(message.what, h.getString(d.l.voice_err_create_file_fail));
                        } else {
                            a.Ji.f(message.what, h.getString(d.l.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.Ji = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Ji != null) {
                        a.Ji.f(message.what, h.getString(d.l.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.Ji = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Ji != null) {
                        a.Ji.ay(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Ji != null) {
                        a.Ji.f(message.what, h.getString(d.l.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.Ji = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Ji != null) {
                        a.Ji.f(message.what, h.getString(d.l.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.Ji = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Ji != null) {
                        a.Ji.f(message.what, h.getString(d.l.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.Ji = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Ji != null) {
                        a.Ji.f(message.what, h.getString(d.l.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.Ji = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Ji != null) {
                        a.Ji.az(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Ji != null) {
                        a.Ji.hL();
                        break;
                    }
                    break;
                default:
                    if (a.Ji != null) {
                        a.Ji.f(message.what, h.getString(d.l.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.Ji = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Jf = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - Jj < 1000) {
            return false;
        }
        Jj = System.currentTimeMillis();
        if (Jf == 0) {
            if (Jg == null) {
                Jg = new b(mHandler);
            }
            Jh = str;
            Ji = gVar;
            if (Jg.o(str, i)) {
                Jf = 3;
                new Thread(Jg).start();
                return true;
            }
            Jg = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Jg != null) {
            Jg.stop();
        }
        Jf = 0;
    }

    public static void cancel() {
        if (Jg != null) {
            Jg.cancel();
        }
        Jf = 0;
    }
}
