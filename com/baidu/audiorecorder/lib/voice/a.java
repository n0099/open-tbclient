package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class a {
    private static b abG;
    private static String abH;
    private static g abI;
    private static int abF = 0;
    private static long abJ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.abI != null) {
                        a.abI.m(a.abH, message.arg1);
                        g unused = a.abI = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.abI != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.abI.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.abI.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.abI = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.abI != null) {
                        a.abI.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.abI = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.abI != null) {
                        a.abI.aE(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.abI != null) {
                        a.abI.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.abI = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.abI != null) {
                        a.abI.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.abI = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.abI != null) {
                        a.abI.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.abI = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.abI != null) {
                        a.abI.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.abI = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.abI != null) {
                        a.abI.aF(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.abI != null) {
                        a.abI.os();
                        break;
                    }
                    break;
                default:
                    if (a.abI != null) {
                        a.abI.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.abI = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.abF = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - abJ < 1000) {
            return false;
        }
        abJ = System.currentTimeMillis();
        if (abF == 0) {
            if (abG == null) {
                abG = new b(mHandler);
            }
            abH = str;
            abI = gVar;
            if (abG.q(str, i)) {
                abF = 3;
                new Thread(abG).start();
                return true;
            }
            abG = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (abG != null) {
            abG.stop();
        }
        abF = 0;
    }

    public static void cancel() {
        if (abG != null) {
            abG.cancel();
        }
        abF = 0;
    }
}
