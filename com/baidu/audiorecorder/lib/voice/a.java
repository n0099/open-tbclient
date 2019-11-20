package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private static b Cd;
    private static String Ce;
    private static g Cf;
    private static int Cc = 0;
    private static long Cg = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Cf != null) {
                        a.Cf.e(a.Ce, message.arg1);
                        g unused = a.Cf = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Cf != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.Cf.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.Cf.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Cf = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Cf != null) {
                        a.Cf.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.Cf = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Cf != null) {
                        a.Cf.U(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Cf != null) {
                        a.Cf.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.Cf = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Cf != null) {
                        a.Cf.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.Cf = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Cf != null) {
                        a.Cf.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.Cf = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Cf != null) {
                        a.Cf.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.Cf = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Cf != null) {
                        a.Cf.V(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Cf != null) {
                        a.Cf.hg();
                        break;
                    }
                    break;
                default:
                    if (a.Cf != null) {
                        a.Cf.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.Cf = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Cc = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Cg < 1000) {
            return false;
        }
        Cg = System.currentTimeMillis();
        if (Cc == 0) {
            if (Cd == null) {
                Cd = new b(mHandler);
            }
            Ce = str;
            Cf = gVar;
            if (Cd.i(str, i)) {
                Cc = 3;
                new Thread(Cd).start();
                return true;
            }
            Cd = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Cd != null) {
            Cd.stop();
        }
        Cc = 0;
    }

    public static void cancel() {
        if (Cd != null) {
            Cd.cancel();
        }
        Cc = 0;
    }
}
