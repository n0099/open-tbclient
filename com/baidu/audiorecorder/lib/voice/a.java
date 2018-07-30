package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private static b Pw;
    private static String Px;
    private static g Py;
    private static int Pv = 0;
    private static long Pz = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Py != null) {
                        a.Py.k(a.Px, message.arg1);
                        g unused = a.Py = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Py != null) {
                        if (com.baidu.adp.lib.util.f.jo()) {
                            a.Py.error(message.what, h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.Py.error(message.what, h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Py = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Py != null) {
                        a.Py.error(message.what, h.getString(d.j.voice_err_file_fail));
                        g unused3 = a.Py = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Py != null) {
                        a.Py.aw(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Py != null) {
                        a.Py.error(message.what, h.getString(d.j.voice_err_load_lib_fail));
                        g unused4 = a.Py = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Py != null) {
                        a.Py.error(message.what, h.getString(d.j.voice_err_init_fail));
                        g unused5 = a.Py = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Py != null) {
                        a.Py.error(message.what, h.getString(d.j.voice_record_timeout_tip));
                        g unused6 = a.Py = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Py != null) {
                        a.Py.error(message.what, h.getString(d.j.voice_record_short_tip));
                        g unused7 = a.Py = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Py != null) {
                        a.Py.ax(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Py != null) {
                        a.Py.ki();
                        break;
                    }
                    break;
                default:
                    if (a.Py != null) {
                        a.Py.error(message.what, h.getString(d.j.voice_err_other));
                        g unused8 = a.Py = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Pv = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Pz < 1000) {
            return false;
        }
        Pz = System.currentTimeMillis();
        if (Pv == 0) {
            if (Pw == null) {
                Pw = new b(mHandler);
            }
            Px = str;
            Py = gVar;
            if (Pw.o(str, i)) {
                Pv = 3;
                new Thread(Pw).start();
                return true;
            }
            Pw = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Pw != null) {
            Pw.stop();
        }
        Pv = 0;
    }

    public static void cancel() {
        if (Pw != null) {
            Pw.cancel();
        }
        Pv = 0;
    }
}
