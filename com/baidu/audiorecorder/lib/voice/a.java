package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b Ik;
    private static String Il;
    private static com.baidu.adp.lib.voice.g Im;
    private static int Ij = 0;
    private static long In = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Im != null) {
                        a.Im.k(a.Il, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.Im = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Im != null) {
                        if (com.baidu.adp.lib.util.f.gR()) {
                            a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.Im = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Im != null) {
                        a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.Im = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Im != null) {
                        a.Im.aA(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Im != null) {
                        a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.Im = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Im != null) {
                        a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.Im = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Im != null) {
                        a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.Im = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Im != null) {
                        a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.Im = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Im != null) {
                        a.Im.aB(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Im != null) {
                        a.Im.hL();
                        break;
                    }
                    break;
                default:
                    if (a.Im != null) {
                        a.Im.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.Im = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Ij = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - In < 1000) {
            return false;
        }
        In = System.currentTimeMillis();
        if (Ij == 0) {
            if (Ik == null) {
                Ik = new b(mHandler);
            }
            Il = str;
            Im = gVar;
            if (Ik.o(str, i)) {
                Ij = 3;
                new Thread(Ik).start();
                return true;
            }
            Ik = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Ik != null) {
            Ik.stop();
        }
        Ij = 0;
    }

    public static void cancel() {
        if (Ik != null) {
            Ik.cancel();
        }
        Ij = 0;
    }
}
