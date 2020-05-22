package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private static b YN;
    private static String YO;
    private static g YP;
    private static int YM = 0;
    private static long YQ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.YP != null) {
                        a.YP.l(a.YO, message.arg1);
                        g unused = a.YP = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.YP != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.YP.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.YP.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.YP = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.YP != null) {
                        a.YP.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.YP = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.YP != null) {
                        a.YP.ao(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.YP != null) {
                        a.YP.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.YP = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.YP != null) {
                        a.YP.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.YP = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.YP != null) {
                        a.YP.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.YP = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.YP != null) {
                        a.YP.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.YP = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.YP != null) {
                        a.YP.ap(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.YP != null) {
                        a.YP.mw();
                        break;
                    }
                    break;
                default:
                    if (a.YP != null) {
                        a.YP.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.YP = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.YM = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - YQ < 1000) {
            return false;
        }
        YQ = System.currentTimeMillis();
        if (YM == 0) {
            if (YN == null) {
                YN = new b(mHandler);
            }
            YO = str;
            YP = gVar;
            if (YN.p(str, i)) {
                YM = 3;
                new Thread(YN).start();
                return true;
            }
            YN = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (YN != null) {
            YN.stop();
        }
        YM = 0;
    }

    public static void cancel() {
        if (YN != null) {
            YN.cancel();
        }
        YM = 0;
    }
}
