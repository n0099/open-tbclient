package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b axb;
    private static String axc;
    private static com.baidu.adp.lib.voice.g axd;
    private static int axa = 0;
    private static long axe = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.axd != null) {
                        a.axd.l(a.axc, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.axd = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.axd != null) {
                        if (com.baidu.adp.lib.util.f.ot()) {
                            a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.axd = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.axd != null) {
                        a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.axd = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.axd != null) {
                        a.axd.du(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.axd != null) {
                        a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.axd = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.axd != null) {
                        a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.axd = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.axd != null) {
                        a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.axd = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.axd != null) {
                        a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.axd = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.axd != null) {
                        a.axd.dv(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.axd != null) {
                        a.axd.pn();
                        break;
                    }
                    break;
                default:
                    if (a.axd != null) {
                        a.axd.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.axd = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.axa = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - axe < 1000) {
            return false;
        }
        axe = System.currentTimeMillis();
        if (axa == 0) {
            if (axb == null) {
                axb = new b(mHandler);
            }
            axc = str;
            axd = gVar;
            if (axb.p(str, i)) {
                axa = 3;
                new Thread(axb).start();
                return true;
            }
            axb = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (axb != null) {
            axb.stop();
        }
        axa = 0;
    }

    public static void cancel() {
        if (axb != null) {
            axb.cancel();
        }
        axa = 0;
    }
}
