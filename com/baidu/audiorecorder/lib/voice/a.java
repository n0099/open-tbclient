package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private static b Sp;
    private static String Sq;
    private static g Sr;
    private static int So = 0;
    private static long Ss = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Sr != null) {
                        a.Sr.p(a.Sq, message.arg1);
                        g unused = a.Sr = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Sr != null) {
                        if (com.baidu.adp.lib.util.f.kI()) {
                            a.Sr.error(message.what, h.getString(e.j.voice_err_create_file_fail));
                        } else {
                            a.Sr.error(message.what, h.getString(e.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Sr = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Sr != null) {
                        a.Sr.error(message.what, h.getString(e.j.voice_err_file_fail));
                        g unused3 = a.Sr = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Sr != null) {
                        a.Sr.aE(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Sr != null) {
                        a.Sr.error(message.what, h.getString(e.j.voice_err_load_lib_fail));
                        g unused4 = a.Sr = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Sr != null) {
                        a.Sr.error(message.what, h.getString(e.j.voice_err_init_fail));
                        g unused5 = a.Sr = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Sr != null) {
                        a.Sr.error(message.what, h.getString(e.j.voice_record_timeout_tip));
                        g unused6 = a.Sr = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Sr != null) {
                        a.Sr.error(message.what, h.getString(e.j.voice_record_short_tip));
                        g unused7 = a.Sr = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Sr != null) {
                        a.Sr.aF(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Sr != null) {
                        a.Sr.lz();
                        break;
                    }
                    break;
                default:
                    if (a.Sr != null) {
                        a.Sr.error(message.what, h.getString(e.j.voice_err_other));
                        g unused8 = a.Sr = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.So = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Ss < 1000) {
            return false;
        }
        Ss = System.currentTimeMillis();
        if (So == 0) {
            if (Sp == null) {
                Sp = new b(mHandler);
            }
            Sq = str;
            Sr = gVar;
            if (Sp.t(str, i)) {
                So = 3;
                new Thread(Sp).start();
                return true;
            }
            Sp = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Sp != null) {
            Sp.stop();
        }
        So = 0;
    }

    public static void cancel() {
        if (Sp != null) {
            Sp.cancel();
        }
        So = 0;
    }
}
