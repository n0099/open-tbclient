package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a {
    private static String PA;
    private static g PC;
    private static b Pz;
    private static int Py = 0;
    private static long PD = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.PC != null) {
                        a.PC.k(a.PA, message.arg1);
                        g unused = a.PC = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.PC != null) {
                        if (com.baidu.adp.lib.util.f.jn()) {
                            a.PC.error(message.what, h.getString(d.k.voice_err_create_file_fail));
                        } else {
                            a.PC.error(message.what, h.getString(d.k.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.PC = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.PC != null) {
                        a.PC.error(message.what, h.getString(d.k.voice_err_file_fail));
                        g unused3 = a.PC = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.PC != null) {
                        a.PC.av(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.PC != null) {
                        a.PC.error(message.what, h.getString(d.k.voice_err_load_lib_fail));
                        g unused4 = a.PC = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.PC != null) {
                        a.PC.error(message.what, h.getString(d.k.voice_err_init_fail));
                        g unused5 = a.PC = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.PC != null) {
                        a.PC.error(message.what, h.getString(d.k.voice_record_timeout_tip));
                        g unused6 = a.PC = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.PC != null) {
                        a.PC.error(message.what, h.getString(d.k.voice_record_short_tip));
                        g unused7 = a.PC = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.PC != null) {
                        a.PC.aw(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.PC != null) {
                        a.PC.kh();
                        break;
                    }
                    break;
                default:
                    if (a.PC != null) {
                        a.PC.error(message.what, h.getString(d.k.voice_err_other));
                        g unused8 = a.PC = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Py = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - PD < 1000) {
            return false;
        }
        PD = System.currentTimeMillis();
        if (Py == 0) {
            if (Pz == null) {
                Pz = new b(mHandler);
            }
            PA = str;
            PC = gVar;
            if (Pz.o(str, i)) {
                Py = 3;
                new Thread(Pz).start();
                return true;
            }
            Pz = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Pz != null) {
            Pz.stop();
        }
        Py = 0;
    }

    public static void cancel() {
        if (Pz != null) {
            Pz.cancel();
        }
        Py = 0;
    }
}
