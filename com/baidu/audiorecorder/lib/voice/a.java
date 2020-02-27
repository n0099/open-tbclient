package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private static b Fj;
    private static String Fk;
    private static g Fl;
    private static int Fi = 0;
    private static long Fm = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Fl != null) {
                        a.Fl.h(a.Fk, message.arg1);
                        g unused = a.Fl = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Fl != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.Fl.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.Fl.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Fl = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Fl != null) {
                        a.Fl.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.Fl = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Fl != null) {
                        a.Fl.ab(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Fl != null) {
                        a.Fl.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.Fl = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Fl != null) {
                        a.Fl.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.Fl = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Fl != null) {
                        a.Fl.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.Fl = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Fl != null) {
                        a.Fl.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.Fl = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Fl != null) {
                        a.Fl.ac(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Fl != null) {
                        a.Fl.hQ();
                        break;
                    }
                    break;
                default:
                    if (a.Fl != null) {
                        a.Fl.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.Fl = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Fi = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Fm < 1000) {
            return false;
        }
        Fm = System.currentTimeMillis();
        if (Fi == 0) {
            if (Fj == null) {
                Fj = new b(mHandler);
            }
            Fk = str;
            Fl = gVar;
            if (Fj.l(str, i)) {
                Fi = 3;
                new Thread(Fj).start();
                return true;
            }
            Fj = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Fj != null) {
            Fj.stop();
        }
        Fi = 0;
    }

    public static void cancel() {
        if (Fj != null) {
            Fj.cancel();
        }
        Fi = 0;
    }
}
