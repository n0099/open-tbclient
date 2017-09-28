package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class a {
    private static b IS;
    private static String IT;
    private static com.baidu.adp.lib.voice.g IU;
    private static int IR = 0;
    private static long IW = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.IU != null) {
                        a.IU.k(a.IT, message.arg1);
                        com.baidu.adp.lib.voice.g unused = a.IU = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.IU != null) {
                        if (com.baidu.adp.lib.util.f.gR()) {
                            a.IU.f(message.what, h.getString(d.l.voice_err_create_file_fail));
                        } else {
                            a.IU.f(message.what, h.getString(d.l.voice_err_sdcard_nospace));
                        }
                        com.baidu.adp.lib.voice.g unused2 = a.IU = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.IU != null) {
                        a.IU.f(message.what, h.getString(d.l.voice_err_file_fail));
                        com.baidu.adp.lib.voice.g unused3 = a.IU = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.IU != null) {
                        a.IU.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.IU != null) {
                        a.IU.f(message.what, h.getString(d.l.voice_err_load_lib_fail));
                        com.baidu.adp.lib.voice.g unused4 = a.IU = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.IU != null) {
                        a.IU.f(message.what, h.getString(d.l.voice_err_init_fail));
                        com.baidu.adp.lib.voice.g unused5 = a.IU = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.IU != null) {
                        a.IU.f(message.what, h.getString(d.l.voice_record_timeout_tip));
                        com.baidu.adp.lib.voice.g unused6 = a.IU = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.IU != null) {
                        a.IU.f(message.what, h.getString(d.l.voice_record_short_tip));
                        com.baidu.adp.lib.voice.g unused7 = a.IU = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.IU != null) {
                        a.IU.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.IU != null) {
                        a.IU.hL();
                        break;
                    }
                    break;
                default:
                    if (a.IU != null) {
                        a.IU.f(message.what, h.getString(d.l.voice_err_other));
                        com.baidu.adp.lib.voice.g unused8 = a.IU = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.IR = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, com.baidu.adp.lib.voice.g gVar) {
        if (System.currentTimeMillis() - IW < 1000) {
            return false;
        }
        IW = System.currentTimeMillis();
        if (IR == 0) {
            if (IS == null) {
                IS = new b(mHandler);
            }
            IT = str;
            IU = gVar;
            if (IS.o(str, i)) {
                IR = 3;
                new Thread(IS).start();
                return true;
            }
            IS = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (IS != null) {
            IS.stop();
        }
        IR = 0;
    }

    public static void cancel() {
        if (IS != null) {
            IS.cancel();
        }
        IR = 0;
    }
}
