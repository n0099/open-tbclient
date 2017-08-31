package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b IA;
    private static String IB;
    private static com.baidu.adp.lib.voice.g IC;
    private static int Iz = 0;
    private static long IE = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.IC != null) {
                        a.IC.k(a.IB, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.IC = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.IC != null) {
                        if (com.baidu.adp.lib.util.e.gS()) {
                            a.IC.f(message.what, h.getString(d.l.voice_err_create_file_fail));
                        } else {
                            a.IC.f(message.what, h.getString(d.l.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.IC = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.IC != null) {
                        a.IC.f(message.what, h.getString(d.l.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.IC = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.IC != null) {
                        a.IC.ay(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.IC != null) {
                        a.IC.f(message.what, h.getString(d.l.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.IC = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.IC != null) {
                        a.IC.f(message.what, h.getString(d.l.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.IC = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.IC != null) {
                        a.IC.f(message.what, h.getString(d.l.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.IC = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.IC != null) {
                        a.IC.f(message.what, h.getString(d.l.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.IC = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.IC != null) {
                        a.IC.az(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.IC != null) {
                        a.IC.hM();
                        break;
                    }
                    break;
                default:
                    if (a.IC != null) {
                        a.IC.f(message.what, h.getString(d.l.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.IC = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Iz = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - IE < 1000) {
            return false;
        }
        IE = System.currentTimeMillis();
        if (Iz == 0) {
            if (IA == null) {
                IA = new b(mHandler);
            }
            IB = str;
            IC = gVar;
            if (IA.o(str, i)) {
                Iz = 3;
                new Thread(IA).start();
                return true;
            }
            IA = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (IA != null) {
            IA.stop();
        }
        Iz = 0;
    }

    public static void cancel() {
        if (IA != null) {
            IA.cancel();
        }
        Iz = 0;
    }
}
