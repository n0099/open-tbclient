package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b axj;
    private static String axk;
    private static com.baidu.adp.lib.voice.g axl;
    private static int axi = 0;
    private static long axm = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.axl != null) {
                        a.axl.l(a.axk, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.axl = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.axl != null) {
                        if (com.baidu.adp.lib.util.f.ot()) {
                            a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.axl = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.axl != null) {
                        a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.axl = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.axl != null) {
                        a.axl.du(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.axl != null) {
                        a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.axl = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.axl != null) {
                        a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.axl = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.axl != null) {
                        a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.axl = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.axl != null) {
                        a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.axl = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.axl != null) {
                        a.axl.dv(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.axl != null) {
                        a.axl.pn();
                        break;
                    }
                    break;
                default:
                    if (a.axl != null) {
                        a.axl.error(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.axl = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.axi = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - axm < 1000) {
            return false;
        }
        axm = System.currentTimeMillis();
        if (axi == 0) {
            if (axj == null) {
                axj = new b(mHandler);
            }
            axk = str;
            axl = gVar;
            if (axj.p(str, i)) {
                axi = 3;
                new Thread(axj).start();
                return true;
            }
            axj = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (axj != null) {
            axj.stop();
        }
        axi = 0;
    }

    public static void cancel() {
        if (axj != null) {
            axj.cancel();
        }
        axi = 0;
    }
}
