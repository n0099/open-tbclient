package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b Il;
    private static String Im;
    private static com.baidu.adp.lib.voice.g In;
    private static int Ik = 0;
    private static long Io = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.In != null) {
                        a.In.k(a.Im, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.In = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.In != null) {
                        if (com.baidu.adp.lib.util.f.gR()) {
                            a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.In = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.In != null) {
                        a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.In = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.In != null) {
                        a.In.aA(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.In != null) {
                        a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.In = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.In != null) {
                        a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.In = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.In != null) {
                        a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.In = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.In != null) {
                        a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.In = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.In != null) {
                        a.In.aB(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.In != null) {
                        a.In.hL();
                        break;
                    }
                    break;
                default:
                    if (a.In != null) {
                        a.In.f(message.what, com.baidu.adp.lib.voice.h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.In = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Ik = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - Io < 1000) {
            return false;
        }
        Io = System.currentTimeMillis();
        if (Ik == 0) {
            if (Il == null) {
                Il = new b(mHandler);
            }
            Im = str;
            In = gVar;
            if (Il.o(str, i)) {
                Ik = 3;
                new Thread(Il).start();
                return true;
            }
            Il = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Il != null) {
            Il.stop();
        }
        Ik = 0;
    }

    public static void cancel() {
        if (Il != null) {
            Il.cancel();
        }
        Ik = 0;
    }
}
