package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private static b Jm;
    private static String Jn;
    private static g Jo;
    private static int Jl = 0;
    private static long Jp = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Jo != null) {
                        a.Jo.k(a.Jn, message.arg1);
                        g unused = a.Jo = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Jo != null) {
                        if (com.baidu.adp.lib.util.f.gy()) {
                            a.Jo.error(message.what, h.getString(d.k.voice_err_create_file_fail));
                        } else {
                            a.Jo.error(message.what, h.getString(d.k.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Jo = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Jo != null) {
                        a.Jo.error(message.what, h.getString(d.k.voice_err_file_fail));
                        g unused3 = a.Jo = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Jo != null) {
                        a.Jo.au(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Jo != null) {
                        a.Jo.error(message.what, h.getString(d.k.voice_err_load_lib_fail));
                        g unused4 = a.Jo = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Jo != null) {
                        a.Jo.error(message.what, h.getString(d.k.voice_err_init_fail));
                        g unused5 = a.Jo = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Jo != null) {
                        a.Jo.error(message.what, h.getString(d.k.voice_record_timeout_tip));
                        g unused6 = a.Jo = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Jo != null) {
                        a.Jo.error(message.what, h.getString(d.k.voice_record_short_tip));
                        g unused7 = a.Jo = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Jo != null) {
                        a.Jo.av(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Jo != null) {
                        a.Jo.ht();
                        break;
                    }
                    break;
                default:
                    if (a.Jo != null) {
                        a.Jo.error(message.what, h.getString(d.k.voice_err_other));
                        g unused8 = a.Jo = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Jl = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Jp < 1000) {
            return false;
        }
        Jp = System.currentTimeMillis();
        if (Jl == 0) {
            if (Jm == null) {
                Jm = new b(mHandler);
            }
            Jn = str;
            Jo = gVar;
            if (Jm.o(str, i)) {
                Jl = 3;
                new Thread(Jm).start();
                return true;
            }
            Jm = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Jm != null) {
            Jm.stop();
        }
        Jl = 0;
    }

    public static void cancel() {
        if (Jm != null) {
            Jm.cancel();
        }
        Jl = 0;
    }
}
