package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b IT;
    private static String IU;
    private static com.baidu.adp.lib.voice.g IW;
    private static int IS = 0;
    private static long IX = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.IW != null) {
                        a.IW.k(a.IU, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.IW = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.IW != null) {
                        if (com.baidu.adp.lib.util.f.gR()) {
                            a.IW.f(message.what, h.getString(d.l.voice_err_create_file_fail));
                        } else {
                            a.IW.f(message.what, h.getString(d.l.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.IW = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.IW != null) {
                        a.IW.f(message.what, h.getString(d.l.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.IW = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.IW != null) {
                        a.IW.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.IW != null) {
                        a.IW.f(message.what, h.getString(d.l.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.IW = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.IW != null) {
                        a.IW.f(message.what, h.getString(d.l.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.IW = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.IW != null) {
                        a.IW.f(message.what, h.getString(d.l.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.IW = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.IW != null) {
                        a.IW.f(message.what, h.getString(d.l.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.IW = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.IW != null) {
                        a.IW.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.IW != null) {
                        a.IW.hL();
                        break;
                    }
                    break;
                default:
                    if (a.IW != null) {
                        a.IW.f(message.what, h.getString(d.l.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.IW = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.IS = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - IX < 1000) {
            return false;
        }
        IX = System.currentTimeMillis();
        if (IS == 0) {
            if (IT == null) {
                IT = new b(mHandler);
            }
            IU = str;
            IW = gVar;
            if (IT.o(str, i)) {
                IS = 3;
                new Thread(IT).start();
                return true;
            }
            IT = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (IT != null) {
            IT.stop();
        }
        IS = 0;
    }

    public static void cancel() {
        if (IT != null) {
            IT.cancel();
        }
        IS = 0;
    }
}
