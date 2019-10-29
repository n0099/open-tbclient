package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private static b CD;
    private static String CE;
    private static g CF;
    private static int CC = 0;
    private static long CG = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.CF != null) {
                        a.CF.e(a.CE, message.arg1);
                        g unused = a.CF = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.CF != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.CF.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.CF.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.CF = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.CF != null) {
                        a.CF.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.CF = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.CF != null) {
                        a.CF.U(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.CF != null) {
                        a.CF.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.CF = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.CF != null) {
                        a.CF.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.CF = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.CF != null) {
                        a.CF.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.CF = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.CF != null) {
                        a.CF.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.CF = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.CF != null) {
                        a.CF.V(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.CF != null) {
                        a.CF.hg();
                        break;
                    }
                    break;
                default:
                    if (a.CF != null) {
                        a.CF.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.CF = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.CC = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - CG < 1000) {
            return false;
        }
        CG = System.currentTimeMillis();
        if (CC == 0) {
            if (CD == null) {
                CD = new b(mHandler);
            }
            CE = str;
            CF = gVar;
            if (CD.i(str, i)) {
                CC = 3;
                new Thread(CD).start();
                return true;
            }
            CD = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (CD != null) {
            CD.stop();
        }
        CC = 0;
    }

    public static void cancel() {
        if (CD != null) {
            CD.cancel();
        }
        CC = 0;
    }
}
