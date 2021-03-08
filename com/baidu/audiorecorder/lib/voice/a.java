package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class a {
    private static b adG;
    private static String adH;
    private static g adI;
    private static int adF = 0;
    private static long adJ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.adI != null) {
                        a.adI.m(a.adH, message.arg1);
                        g unused = a.adI = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.adI != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.adI.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.adI.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.adI = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.adI != null) {
                        a.adI.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.adI = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.adI != null) {
                        a.adI.aF(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.adI != null) {
                        a.adI.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.adI = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.adI != null) {
                        a.adI.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.adI = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.adI != null) {
                        a.adI.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.adI = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.adI != null) {
                        a.adI.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.adI = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.adI != null) {
                        a.adI.aG(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.adI != null) {
                        a.adI.nS();
                        break;
                    }
                    break;
                default:
                    if (a.adI != null) {
                        a.adI.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.adI = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.adF = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - adJ < 1000) {
            return false;
        }
        adJ = System.currentTimeMillis();
        if (adF == 0) {
            if (adG == null) {
                adG = new b(mHandler);
            }
            adH = str;
            adI = gVar;
            if (adG.q(str, i)) {
                adF = 3;
                new Thread(adG).start();
                return true;
            }
            adG = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (adG != null) {
            adG.stop();
        }
        adF = 0;
    }

    public static void cancel() {
        if (adG != null) {
            adG.cancel();
        }
        adF = 0;
    }
}
