package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private static b Px;
    private static String Py;
    private static g Pz;
    private static int Pw = 0;
    private static long PA = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Pz != null) {
                        a.Pz.k(a.Py, message.arg1);
                        g unused = a.Pz = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Pz != null) {
                        if (com.baidu.adp.lib.util.f.jn()) {
                            a.Pz.error(message.what, h.getString(d.k.voice_err_create_file_fail));
                        } else {
                            a.Pz.error(message.what, h.getString(d.k.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Pz = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Pz != null) {
                        a.Pz.error(message.what, h.getString(d.k.voice_err_file_fail));
                        g unused3 = a.Pz = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Pz != null) {
                        a.Pz.av(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Pz != null) {
                        a.Pz.error(message.what, h.getString(d.k.voice_err_load_lib_fail));
                        g unused4 = a.Pz = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Pz != null) {
                        a.Pz.error(message.what, h.getString(d.k.voice_err_init_fail));
                        g unused5 = a.Pz = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Pz != null) {
                        a.Pz.error(message.what, h.getString(d.k.voice_record_timeout_tip));
                        g unused6 = a.Pz = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Pz != null) {
                        a.Pz.error(message.what, h.getString(d.k.voice_record_short_tip));
                        g unused7 = a.Pz = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Pz != null) {
                        a.Pz.aw(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Pz != null) {
                        a.Pz.kh();
                        break;
                    }
                    break;
                default:
                    if (a.Pz != null) {
                        a.Pz.error(message.what, h.getString(d.k.voice_err_other));
                        g unused8 = a.Pz = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Pw = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - PA < 1000) {
            return false;
        }
        PA = System.currentTimeMillis();
        if (Pw == 0) {
            if (Px == null) {
                Px = new b(mHandler);
            }
            Py = str;
            Pz = gVar;
            if (Px.o(str, i)) {
                Pw = 3;
                new Thread(Px).start();
                return true;
            }
            Px = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Px != null) {
            Px.stop();
        }
        Pw = 0;
    }

    public static void cancel() {
        if (Px != null) {
            Px.cancel();
        }
        Pw = 0;
    }
}
