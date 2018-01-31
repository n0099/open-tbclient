package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b axk;
    private static String axl;
    private static com.baidu.adp.lib.voice.g axm;
    private static int axj = 0;
    private static long axn = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.axm != null) {
                        a.axm.l(a.axl, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.axm = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.axm != null) {
                        if (com.baidu.adp.lib.util.f.ot()) {
                            a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.axm = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.axm != null) {
                        a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.axm = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.axm != null) {
                        a.axm.du(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.axm != null) {
                        a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.axm = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.axm != null) {
                        a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.axm = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.axm != null) {
                        a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.axm = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.axm != null) {
                        a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.axm = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.axm != null) {
                        a.axm.dv(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.axm != null) {
                        a.axm.pn();
                        break;
                    }
                    break;
                default:
                    if (a.axm != null) {
                        a.axm.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.axm = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.axj = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - axn < 1000) {
            return false;
        }
        axn = System.currentTimeMillis();
        if (axj == 0) {
            if (axk == null) {
                axk = new b(mHandler);
            }
            axl = str;
            axm = gVar;
            if (axk.p(str, i)) {
                axj = 3;
                new Thread(axk).start();
                return true;
            }
            axk = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (axk != null) {
            axk.stop();
        }
        axj = 0;
    }

    public static void cancel() {
        if (axk != null) {
            axk.cancel();
        }
        axj = 0;
    }
}
