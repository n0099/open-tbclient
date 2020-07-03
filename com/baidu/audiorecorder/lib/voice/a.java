package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private static b Zs;
    private static String Zt;
    private static g Zu;
    private static int Zr = 0;
    private static long Zv = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Zu != null) {
                        a.Zu.l(a.Zt, message.arg1);
                        g unused = a.Zu = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Zu != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.Zu.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.Zu.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Zu = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Zu != null) {
                        a.Zu.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.Zu = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Zu != null) {
                        a.Zu.au(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Zu != null) {
                        a.Zu.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.Zu = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Zu != null) {
                        a.Zu.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.Zu = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Zu != null) {
                        a.Zu.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.Zu = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Zu != null) {
                        a.Zu.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.Zu = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Zu != null) {
                        a.Zu.av(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Zu != null) {
                        a.Zu.mM();
                        break;
                    }
                    break;
                default:
                    if (a.Zu != null) {
                        a.Zu.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.Zu = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Zr = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Zv < 1000) {
            return false;
        }
        Zv = System.currentTimeMillis();
        if (Zr == 0) {
            if (Zs == null) {
                Zs = new b(mHandler);
            }
            Zt = str;
            Zu = gVar;
            if (Zs.p(str, i)) {
                Zr = 3;
                new Thread(Zs).start();
                return true;
            }
            Zs = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Zs != null) {
            Zs.stop();
        }
        Zr = 0;
    }

    public static void cancel() {
        if (Zs != null) {
            Zs.cancel();
        }
        Zr = 0;
    }
}
