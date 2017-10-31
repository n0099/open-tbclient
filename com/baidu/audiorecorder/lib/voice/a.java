package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b Im;
    private static String In;
    private static com.baidu.adp.lib.voice.g Io;
    private static int Il = 0;
    private static long Ip = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Io != null) {
                        a.Io.k(a.In, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.Io = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Io != null) {
                        if (com.baidu.adp.lib.util.f.gR()) {
                            a.Io.f(message.what, h.getString(d.j.voice_err_create_file_fail));
                        } else {
                            a.Io.f(message.what, h.getString(d.j.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.Io = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Io != null) {
                        a.Io.f(message.what, h.getString(d.j.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.Io = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Io != null) {
                        a.Io.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Io != null) {
                        a.Io.f(message.what, h.getString(d.j.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.Io = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Io != null) {
                        a.Io.f(message.what, h.getString(d.j.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.Io = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Io != null) {
                        a.Io.f(message.what, h.getString(d.j.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.Io = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Io != null) {
                        a.Io.f(message.what, h.getString(d.j.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.Io = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Io != null) {
                        a.Io.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Io != null) {
                        a.Io.hL();
                        break;
                    }
                    break;
                default:
                    if (a.Io != null) {
                        a.Io.f(message.what, h.getString(d.j.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.Io = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Il = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - Ip < 1000) {
            return false;
        }
        Ip = System.currentTimeMillis();
        if (Il == 0) {
            if (Im == null) {
                Im = new b(mHandler);
            }
            In = str;
            Io = gVar;
            if (Im.o(str, i)) {
                Il = 3;
                new Thread(Im).start();
                return true;
            }
            Im = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Im != null) {
            Im.stop();
        }
        Il = 0;
    }

    public static void cancel() {
        if (Im != null) {
            Im.cancel();
        }
        Il = 0;
    }
}
