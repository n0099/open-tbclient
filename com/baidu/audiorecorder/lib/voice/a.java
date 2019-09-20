package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private static b Tl;
    private static String Tm;
    private static g Tn;
    private static int Tk = 0;
    private static long To = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Tn != null) {
                        a.Tn.j(a.Tm, message.arg1);
                        g unused = a.Tn = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Tn != null) {
                        if (com.baidu.adp.lib.util.f.jL()) {
                            a.Tn.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.Tn.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Tn = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Tn != null) {
                        a.Tn.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.Tn = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Tn != null) {
                        a.Tn.ax(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Tn != null) {
                        a.Tn.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.Tn = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Tn != null) {
                        a.Tn.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.Tn = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Tn != null) {
                        a.Tn.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.Tn = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Tn != null) {
                        a.Tn.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.Tn = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Tn != null) {
                        a.Tn.ay(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Tn != null) {
                        a.Tn.kG();
                        break;
                    }
                    break;
                default:
                    if (a.Tn != null) {
                        a.Tn.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.Tn = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Tk = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - To < 1000) {
            return false;
        }
        To = System.currentTimeMillis();
        if (Tk == 0) {
            if (Tl == null) {
                Tl = new b(mHandler);
            }
            Tm = str;
            Tn = gVar;
            if (Tl.n(str, i)) {
                Tk = 3;
                new Thread(Tl).start();
                return true;
            }
            Tl = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Tl != null) {
            Tl.stop();
        }
        Tk = 0;
    }

    public static void cancel() {
        if (Tl != null) {
            Tl.cancel();
        }
        Tk = 0;
    }
}
