package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class a {
    private static b Vh;
    private static String Vi;
    private static g Vj;
    private static int Vg = 0;
    private static long Vk = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Vj != null) {
                        a.Vj.p(a.Vi, message.arg1);
                        g unused = a.Vj = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Vj != null) {
                        if (com.baidu.adp.lib.util.f.kI()) {
                            a.Vj.error(message.what, h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.Vj.error(message.what, h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Vj = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Vj != null) {
                        a.Vj.error(message.what, h.getString(d.j.voice_err_file_fail));
                        g unused3 = a.Vj = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Vj != null) {
                        a.Vj.aE(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Vj != null) {
                        a.Vj.error(message.what, h.getString(d.j.voice_err_load_lib_fail));
                        g unused4 = a.Vj = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Vj != null) {
                        a.Vj.error(message.what, h.getString(d.j.voice_err_init_fail));
                        g unused5 = a.Vj = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Vj != null) {
                        a.Vj.error(message.what, h.getString(d.j.voice_record_timeout_tip));
                        g unused6 = a.Vj = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Vj != null) {
                        a.Vj.error(message.what, h.getString(d.j.voice_record_short_tip));
                        g unused7 = a.Vj = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Vj != null) {
                        a.Vj.aF(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Vj != null) {
                        a.Vj.lB();
                        break;
                    }
                    break;
                default:
                    if (a.Vj != null) {
                        a.Vj.error(message.what, h.getString(d.j.voice_err_other));
                        g unused8 = a.Vj = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Vg = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Vk < 1000) {
            return false;
        }
        Vk = System.currentTimeMillis();
        if (Vg == 0) {
            if (Vh == null) {
                Vh = new b(mHandler);
            }
            Vi = str;
            Vj = gVar;
            if (Vh.t(str, i)) {
                Vg = 3;
                new Thread(Vh).start();
                return true;
            }
            Vh = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Vh != null) {
            Vh.stop();
        }
        Vg = 0;
    }

    public static void cancel() {
        if (Vh != null) {
            Vh.cancel();
        }
        Vg = 0;
    }
}
