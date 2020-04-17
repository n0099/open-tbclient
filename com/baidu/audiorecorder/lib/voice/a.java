package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class a {
    private static b Yv;
    private static String Yw;
    private static g Yx;
    private static int Yu = 0;
    private static long Yy = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Yx != null) {
                        a.Yx.l(a.Yw, message.arg1);
                        g unused = a.Yx = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.Yx != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.Yx.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.Yx.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.Yx = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.Yx != null) {
                        a.Yx.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.Yx = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.Yx != null) {
                        a.Yx.an(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.Yx != null) {
                        a.Yx.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.Yx = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.Yx != null) {
                        a.Yx.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.Yx = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.Yx != null) {
                        a.Yx.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.Yx = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.Yx != null) {
                        a.Yx.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.Yx = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.Yx != null) {
                        a.Yx.ao(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.Yx != null) {
                        a.Yx.mu();
                        break;
                    }
                    break;
                default:
                    if (a.Yx != null) {
                        a.Yx.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.Yx = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Yu = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - Yy < 1000) {
            return false;
        }
        Yy = System.currentTimeMillis();
        if (Yu == 0) {
            if (Yv == null) {
                Yv = new b(mHandler);
            }
            Yw = str;
            Yx = gVar;
            if (Yv.p(str, i)) {
                Yu = 3;
                new Thread(Yv).start();
                return true;
            }
            Yv = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (Yv != null) {
            Yv.stop();
        }
        Yu = 0;
    }

    public static void cancel() {
        if (Yv != null) {
            Yv.cancel();
        }
        Yu = 0;
    }
}
