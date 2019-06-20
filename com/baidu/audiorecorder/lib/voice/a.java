package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class a {
    private static b SU;
    private static String SV;
    private static g SW;
    private static int ST = 0;
    private static long SX = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.SW != null) {
                        a.SW.j(a.SV, message.arg1);
                        g unused = a.SW = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.SW != null) {
                        if (com.baidu.adp.lib.util.f.jC()) {
                            a.SW.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.SW.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.SW = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.SW != null) {
                        a.SW.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.SW = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.SW != null) {
                        a.SW.ax(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.SW != null) {
                        a.SW.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.SW = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.SW != null) {
                        a.SW.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.SW = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.SW != null) {
                        a.SW.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.SW = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.SW != null) {
                        a.SW.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.SW = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.SW != null) {
                        a.SW.ay(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.SW != null) {
                        a.SW.kv();
                        break;
                    }
                    break;
                default:
                    if (a.SW != null) {
                        a.SW.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.SW = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.ST = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - SX < 1000) {
            return false;
        }
        SX = System.currentTimeMillis();
        if (ST == 0) {
            if (SU == null) {
                SU = new b(mHandler);
            }
            SV = str;
            SW = gVar;
            if (SU.n(str, i)) {
                ST = 3;
                new Thread(SU).start();
                return true;
            }
            SU = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (SU != null) {
            SU.stop();
        }
        ST = 0;
    }

    public static void cancel() {
        if (SU != null) {
            SU.cancel();
        }
        ST = 0;
    }
}
