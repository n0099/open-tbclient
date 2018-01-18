package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b axh;
    private static String axi;
    private static com.baidu.adp.lib.voice.g axj;
    private static int axg = 0;
    private static long axk = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.axj != null) {
                        a.axj.l(a.axi, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.axj = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.axj != null) {
                        if (com.baidu.adp.lib.util.f.os()) {
                            a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.axj = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.axj != null) {
                        a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.axj = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.axj != null) {
                        a.axj.du(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.axj != null) {
                        a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.axj = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.axj != null) {
                        a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.axj = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.axj != null) {
                        a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.axj = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.axj != null) {
                        a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.axj = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.axj != null) {
                        a.axj.dv(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.axj != null) {
                        a.axj.pm();
                        break;
                    }
                    break;
                default:
                    if (a.axj != null) {
                        a.axj.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.axj = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.axg = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - axk < 1000) {
            return false;
        }
        axk = System.currentTimeMillis();
        if (axg == 0) {
            if (axh == null) {
                axh = new b(mHandler);
            }
            axi = str;
            axj = gVar;
            if (axh.p(str, i)) {
                axg = 3;
                new Thread(axh).start();
                return true;
            }
            axh = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (axh != null) {
            axh.stop();
        }
        axg = 0;
    }

    public static void cancel() {
        if (axh != null) {
            axh.cancel();
        }
        axg = 0;
    }
}
