package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private static b Sr;
    private static String Ss;
    private static g St;
    private static int Sq = 0;
    private static long Su = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.St != null) {
                        a.St.p(a.Ss, message.arg1);
                        g unused = a.St = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.St != null) {
                        if (com.baidu.adp.lib.util.f.kG()) {
                            a.St.error(message.what, h.getString(e.j.voice_err_create_file_fail));
                        } else {
                            a.St.error(message.what, h.getString(e.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.St = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.St != null) {
                        a.St.error(message.what, h.getString(e.j.voice_err_file_fail));
                        g unused3 = a.St = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.St != null) {
                        a.St.aV(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.St != null) {
                        a.St.error(message.what, h.getString(e.j.voice_err_load_lib_fail));
                        g unused4 = a.St = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.St != null) {
                        a.St.error(message.what, h.getString(e.j.voice_err_init_fail));
                        g unused5 = a.St = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.St != null) {
                        a.St.error(message.what, h.getString(e.j.voice_record_timeout_tip));
                        g unused6 = a.St = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.St != null) {
                        a.St.error(message.what, h.getString(e.j.voice_record_short_tip));
                        g unused7 = a.St = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.St != null) {
                        a.St.aW(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.St != null) {
                        a.St.lx();
                        break;
                    }
                    break;
                default:
                    if (a.St != null) {
                        a.St.error(message.what, h.getString(e.j.voice_err_other));
                        g unused8 = a.St = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Sq = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Su < 1000) {
            return false;
        }
        Su = System.currentTimeMillis();
        if (Sq == 0) {
            if (Sr == null) {
                Sr = new b(mHandler);
            }
            Ss = str;
            St = gVar;
            if (Sr.t(str, i)) {
                Sq = 3;
                new Thread(Sr).start();
                return true;
            }
            Sr = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Sr != null) {
            Sr.stop();
        }
        Sq = 0;
    }

    public static void cancel() {
        if (Sr != null) {
            Sr.cancel();
        }
        Sq = 0;
    }
}
