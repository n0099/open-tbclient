package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class a {
    private static b Vi;
    private static String Vj;
    private static g Vk;
    private static int Vh = 0;
    private static long Vl = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Vk != null) {
                        a.Vk.p(a.Vj, message.arg1);
                        g unused = a.Vk = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Vk != null) {
                        if (com.baidu.adp.lib.util.f.kI()) {
                            a.Vk.error(message.what, h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.Vk.error(message.what, h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Vk = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Vk != null) {
                        a.Vk.error(message.what, h.getString(d.j.voice_err_file_fail));
                        g unused3 = a.Vk = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Vk != null) {
                        a.Vk.aE(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Vk != null) {
                        a.Vk.error(message.what, h.getString(d.j.voice_err_load_lib_fail));
                        g unused4 = a.Vk = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Vk != null) {
                        a.Vk.error(message.what, h.getString(d.j.voice_err_init_fail));
                        g unused5 = a.Vk = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Vk != null) {
                        a.Vk.error(message.what, h.getString(d.j.voice_record_timeout_tip));
                        g unused6 = a.Vk = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Vk != null) {
                        a.Vk.error(message.what, h.getString(d.j.voice_record_short_tip));
                        g unused7 = a.Vk = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Vk != null) {
                        a.Vk.aF(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Vk != null) {
                        a.Vk.lB();
                        break;
                    }
                    break;
                default:
                    if (a.Vk != null) {
                        a.Vk.error(message.what, h.getString(d.j.voice_err_other));
                        g unused8 = a.Vk = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Vh = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Vl < 1000) {
            return false;
        }
        Vl = System.currentTimeMillis();
        if (Vh == 0) {
            if (Vi == null) {
                Vi = new b(mHandler);
            }
            Vj = str;
            Vk = gVar;
            if (Vi.t(str, i)) {
                Vh = 3;
                new Thread(Vi).start();
                return true;
            }
            Vi = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Vi != null) {
            Vi.stop();
        }
        Vh = 0;
    }

    public static void cancel() {
        if (Vi != null) {
            Vi.cancel();
        }
        Vh = 0;
    }
}
