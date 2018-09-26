package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private static b Sa;
    private static String Sb;
    private static g Sc;
    private static int RZ = 0;
    private static long Sd = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Sc != null) {
                        a.Sc.p(a.Sb, message.arg1);
                        g unused = a.Sc = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Sc != null) {
                        if (com.baidu.adp.lib.util.f.ku()) {
                            a.Sc.error(message.what, h.getString(e.j.voice_err_create_file_fail));
                        } else {
                            a.Sc.error(message.what, h.getString(e.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Sc = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Sc != null) {
                        a.Sc.error(message.what, h.getString(e.j.voice_err_file_fail));
                        g unused3 = a.Sc = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Sc != null) {
                        a.Sc.aE(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Sc != null) {
                        a.Sc.error(message.what, h.getString(e.j.voice_err_load_lib_fail));
                        g unused4 = a.Sc = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Sc != null) {
                        a.Sc.error(message.what, h.getString(e.j.voice_err_init_fail));
                        g unused5 = a.Sc = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Sc != null) {
                        a.Sc.error(message.what, h.getString(e.j.voice_record_timeout_tip));
                        g unused6 = a.Sc = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Sc != null) {
                        a.Sc.error(message.what, h.getString(e.j.voice_record_short_tip));
                        g unused7 = a.Sc = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Sc != null) {
                        a.Sc.aF(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Sc != null) {
                        a.Sc.lo();
                        break;
                    }
                    break;
                default:
                    if (a.Sc != null) {
                        a.Sc.error(message.what, h.getString(e.j.voice_err_other));
                        g unused8 = a.Sc = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.RZ = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Sd < 1000) {
            return false;
        }
        Sd = System.currentTimeMillis();
        if (RZ == 0) {
            if (Sa == null) {
                Sa = new b(mHandler);
            }
            Sb = str;
            Sc = gVar;
            if (Sa.t(str, i)) {
                RZ = 3;
                new Thread(Sa).start();
                return true;
            }
            Sa = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Sa != null) {
            Sa.stop();
        }
        RZ = 0;
    }

    public static void cancel() {
        if (Sa != null) {
            Sa.cancel();
        }
        RZ = 0;
    }
}
