package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b axi;
    private static String axj;
    private static com.baidu.adp.lib.voice.g axk;
    private static int axh = 0;
    private static long axl = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.axk != null) {
                        a.axk.l(a.axj, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.axk = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.axk != null) {
                        if (com.baidu.adp.lib.util.f.os()) {
                            a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.axk = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.axk != null) {
                        a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.axk = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.axk != null) {
                        a.axk.du(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.axk != null) {
                        a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.axk = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.axk != null) {
                        a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.axk = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.axk != null) {
                        a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.axk = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.axk != null) {
                        a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.axk = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.axk != null) {
                        a.axk.dv(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.axk != null) {
                        a.axk.pm();
                        break;
                    }
                    break;
                default:
                    if (a.axk != null) {
                        a.axk.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.axk = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.axh = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - axl < 1000) {
            return false;
        }
        axl = System.currentTimeMillis();
        if (axh == 0) {
            if (axi == null) {
                axi = new b(mHandler);
            }
            axj = str;
            axk = gVar;
            if (axi.p(str, i)) {
                axh = 3;
                new Thread(axi).start();
                return true;
            }
            axi = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (axi != null) {
            axi.stop();
        }
        axh = 0;
    }

    public static void cancel() {
        if (axi != null) {
            axi.cancel();
        }
        axh = 0;
    }
}
