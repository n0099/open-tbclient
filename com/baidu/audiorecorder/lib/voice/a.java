package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class a {
    private static b Zn;
    private static String Zo;
    private static g Zp;
    private static int Zm = 0;
    private static long Zq = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Zp != null) {
                        a.Zp.l(a.Zo, message.arg1);
                        g unused = a.Zp = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Zp != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.Zp.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.Zp.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Zp = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Zp != null) {
                        a.Zp.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.Zp = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Zp != null) {
                        a.Zp.aw(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Zp != null) {
                        a.Zp.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.Zp = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Zp != null) {
                        a.Zp.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.Zp = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Zp != null) {
                        a.Zp.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.Zp = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Zp != null) {
                        a.Zp.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.Zp = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Zp != null) {
                        a.Zp.ax(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Zp != null) {
                        a.Zp.mN();
                        break;
                    }
                    break;
                default:
                    if (a.Zp != null) {
                        a.Zp.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.Zp = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Zm = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Zq < 1000) {
            return false;
        }
        Zq = System.currentTimeMillis();
        if (Zm == 0) {
            if (Zn == null) {
                Zn = new b(mHandler);
            }
            Zo = str;
            Zp = gVar;
            if (Zn.p(str, i)) {
                Zm = 3;
                new Thread(Zn).start();
                return true;
            }
            Zn = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Zn != null) {
            Zn.stop();
        }
        Zm = 0;
    }

    public static void cancel() {
        if (Zn != null) {
            Zn.cancel();
        }
        Zm = 0;
    }
}
