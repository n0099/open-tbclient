package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a {
    private static b acq;
    private static String acr;
    private static g acs;
    private static int acp = 0;
    private static long acu = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.acs != null) {
                        a.acs.m(a.acr, message.arg1);
                        g unused = a.acs = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.acs != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.acs.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.acs.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.acs = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.acs != null) {
                        a.acs.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.acs = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.acs != null) {
                        a.acs.aF(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.acs != null) {
                        a.acs.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.acs = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.acs != null) {
                        a.acs.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.acs = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.acs != null) {
                        a.acs.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.acs = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.acs != null) {
                        a.acs.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.acs = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.acs != null) {
                        a.acs.aG(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.acs != null) {
                        a.acs.nT();
                        break;
                    }
                    break;
                default:
                    if (a.acs != null) {
                        a.acs.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.acs = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.acp = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - acu < 1000) {
            return false;
        }
        acu = System.currentTimeMillis();
        if (acp == 0) {
            if (acq == null) {
                acq = new b(mHandler);
            }
            acr = str;
            acs = gVar;
            if (acq.q(str, i)) {
                acp = 3;
                new Thread(acq).start();
                return true;
            }
            acq = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (acq != null) {
            acq.stop();
        }
        acp = 0;
    }

    public static void cancel() {
        if (acq != null) {
            acq.cancel();
        }
        acp = 0;
    }
}
