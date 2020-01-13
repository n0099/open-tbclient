package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a {
    private static b EP;
    private static String ER;
    private static g ES;
    private static int EO = 0;
    private static long ET = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.ES != null) {
                        a.ES.h(a.ER, message.arg1);
                        g unused = a.ES = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.ES != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.ES.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.ES.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.ES = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.ES != null) {
                        a.ES.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.ES = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.ES != null) {
                        a.ES.Y(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.ES != null) {
                        a.ES.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.ES = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.ES != null) {
                        a.ES.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.ES = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.ES != null) {
                        a.ES.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.ES = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.ES != null) {
                        a.ES.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.ES = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.ES != null) {
                        a.ES.Z(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.ES != null) {
                        a.ES.hC();
                        break;
                    }
                    break;
                default:
                    if (a.ES != null) {
                        a.ES.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.ES = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.EO = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - ET < 1000) {
            return false;
        }
        ET = System.currentTimeMillis();
        if (EO == 0) {
            if (EP == null) {
                EP = new b(mHandler);
            }
            ER = str;
            ES = gVar;
            if (EP.l(str, i)) {
                EO = 3;
                new Thread(EP).start();
                return true;
            }
            EP = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (EP != null) {
            EP.stop();
        }
        EO = 0;
    }

    public static void cancel() {
        if (EP != null) {
            EP.cancel();
        }
        EO = 0;
    }
}
