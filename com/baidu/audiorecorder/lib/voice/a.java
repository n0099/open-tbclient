package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b axa;
    private static String axb;
    private static com.baidu.adp.lib.voice.g axc;
    private static int awZ = 0;
    private static long axd = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.axc != null) {
                        a.axc.l(a.axb, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.axc = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.axc != null) {
                        if (com.baidu.adp.lib.util.f.ot()) {
                            a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.axc = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.axc != null) {
                        a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.axc = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.axc != null) {
                        a.axc.du(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.axc != null) {
                        a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.axc = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.axc != null) {
                        a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.axc = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.axc != null) {
                        a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.axc = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.axc != null) {
                        a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.axc = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.axc != null) {
                        a.axc.dv(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.axc != null) {
                        a.axc.pn();
                        break;
                    }
                    break;
                default:
                    if (a.axc != null) {
                        a.axc.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.axc = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.awZ = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - axd < 1000) {
            return false;
        }
        axd = System.currentTimeMillis();
        if (awZ == 0) {
            if (axa == null) {
                axa = new b(mHandler);
            }
            axb = str;
            axc = gVar;
            if (axa.p(str, i)) {
                awZ = 3;
                new Thread(axa).start();
                return true;
            }
            axa = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (axa != null) {
            axa.stop();
        }
        awZ = 0;
    }

    public static void cancel() {
        if (axa != null) {
            axa.cancel();
        }
        awZ = 0;
    }
}
