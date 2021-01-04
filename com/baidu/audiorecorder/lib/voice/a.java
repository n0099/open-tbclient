package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private static b acs;
    private static String acu;
    private static g acv;
    private static int acr = 0;
    private static long acx = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.acv != null) {
                        a.acv.m(a.acu, message.arg1);
                        g unused = a.acv = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.acv != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.acv.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.acv.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.acv = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.acv != null) {
                        a.acv.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.acv = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.acv != null) {
                        a.acv.aF(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.acv != null) {
                        a.acv.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.acv = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.acv != null) {
                        a.acv.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.acv = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.acv != null) {
                        a.acv.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.acv = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.acv != null) {
                        a.acv.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.acv = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.acv != null) {
                        a.acv.aG(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.acv != null) {
                        a.acv.nT();
                        break;
                    }
                    break;
                default:
                    if (a.acv != null) {
                        a.acv.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.acv = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.acr = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - acx < 1000) {
            return false;
        }
        acx = System.currentTimeMillis();
        if (acr == 0) {
            if (acs == null) {
                acs = new b(mHandler);
            }
            acu = str;
            acv = gVar;
            if (acs.q(str, i)) {
                acr = 3;
                new Thread(acs).start();
                return true;
            }
            acs = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (acs != null) {
            acs.stop();
        }
        acr = 0;
    }

    public static void cancel() {
        if (acs != null) {
            acs.cancel();
        }
        acr = 0;
    }
}
