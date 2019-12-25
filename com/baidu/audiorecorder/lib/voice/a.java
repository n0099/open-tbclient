package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private static b EK;
    private static String EL;
    private static g EM;
    private static int EJ = 0;
    private static long EN = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.EM != null) {
                        a.EM.h(a.EL, message.arg1);
                        g unused = a.EM = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.EM != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.EM.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.EM.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.EM = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.EM != null) {
                        a.EM.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.EM = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.EM != null) {
                        a.EM.Y(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.EM != null) {
                        a.EM.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.EM = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.EM != null) {
                        a.EM.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.EM = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.EM != null) {
                        a.EM.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.EM = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.EM != null) {
                        a.EM.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.EM = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.EM != null) {
                        a.EM.Z(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.EM != null) {
                        a.EM.hD();
                        break;
                    }
                    break;
                default:
                    if (a.EM != null) {
                        a.EM.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.EM = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.EJ = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - EN < 1000) {
            return false;
        }
        EN = System.currentTimeMillis();
        if (EJ == 0) {
            if (EK == null) {
                EK = new b(mHandler);
            }
            EL = str;
            EM = gVar;
            if (EK.l(str, i)) {
                EJ = 3;
                new Thread(EK).start();
                return true;
            }
            EK = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (EK != null) {
            EK.stop();
        }
        EJ = 0;
    }

    public static void cancel() {
        if (EK != null) {
            EK.cancel();
        }
        EJ = 0;
    }
}
