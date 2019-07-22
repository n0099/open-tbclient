package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private static b Tm;
    private static String Tn;
    private static g To;
    private static int Tl = 0;
    private static long Tp = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.To != null) {
                        a.To.j(a.Tn, message.arg1);
                        g unused = a.To = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.To != null) {
                        if (com.baidu.adp.lib.util.f.jL()) {
                            a.To.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.To.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.To = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.To != null) {
                        a.To.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.To = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.To != null) {
                        a.To.ax(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.To != null) {
                        a.To.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.To = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.To != null) {
                        a.To.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.To = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.To != null) {
                        a.To.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.To = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.To != null) {
                        a.To.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.To = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.To != null) {
                        a.To.ay(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.To != null) {
                        a.To.kG();
                        break;
                    }
                    break;
                default:
                    if (a.To != null) {
                        a.To.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.To = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Tl = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Tp < 1000) {
            return false;
        }
        Tp = System.currentTimeMillis();
        if (Tl == 0) {
            if (Tm == null) {
                Tm = new b(mHandler);
            }
            Tn = str;
            To = gVar;
            if (Tm.n(str, i)) {
                Tl = 3;
                new Thread(Tm).start();
                return true;
            }
            Tm = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Tm != null) {
            Tm.stop();
        }
        Tl = 0;
    }

    public static void cancel() {
        if (Tm != null) {
            Tm.cancel();
        }
        Tl = 0;
    }
}
