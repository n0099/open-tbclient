package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private static b Ji;
    private static String Jj;
    private static g Jk;
    private static int Jh = 0;
    private static long Jl = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Jk != null) {
                        a.Jk.k(a.Jj, message.arg1);
                        g unused = a.Jk = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Jk != null) {
                        if (com.baidu.adp.lib.util.f.gy()) {
                            a.Jk.error(message.what, h.getString(d.k.voice_err_create_file_fail));
                        } else {
                            a.Jk.error(message.what, h.getString(d.k.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Jk = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Jk != null) {
                        a.Jk.error(message.what, h.getString(d.k.voice_err_file_fail));
                        g unused3 = a.Jk = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Jk != null) {
                        a.Jk.au(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Jk != null) {
                        a.Jk.error(message.what, h.getString(d.k.voice_err_load_lib_fail));
                        g unused4 = a.Jk = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Jk != null) {
                        a.Jk.error(message.what, h.getString(d.k.voice_err_init_fail));
                        g unused5 = a.Jk = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Jk != null) {
                        a.Jk.error(message.what, h.getString(d.k.voice_record_timeout_tip));
                        g unused6 = a.Jk = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Jk != null) {
                        a.Jk.error(message.what, h.getString(d.k.voice_record_short_tip));
                        g unused7 = a.Jk = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Jk != null) {
                        a.Jk.av(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Jk != null) {
                        a.Jk.ht();
                        break;
                    }
                    break;
                default:
                    if (a.Jk != null) {
                        a.Jk.error(message.what, h.getString(d.k.voice_err_other));
                        g unused8 = a.Jk = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Jh = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Jl < 1000) {
            return false;
        }
        Jl = System.currentTimeMillis();
        if (Jh == 0) {
            if (Ji == null) {
                Ji = new b(mHandler);
            }
            Jj = str;
            Jk = gVar;
            if (Ji.o(str, i)) {
                Jh = 3;
                new Thread(Ji).start();
                return true;
            }
            Ji = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Ji != null) {
            Ji.stop();
        }
        Jh = 0;
    }

    public static void cancel() {
        if (Ji != null) {
            Ji.cancel();
        }
        Jh = 0;
    }
}
