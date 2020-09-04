package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class a {
    private static b ZU;
    private static String ZV;
    private static g ZW;
    private static int ZT = 0;
    private static long ZX = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.ZW != null) {
                        a.ZW.m(a.ZV, message.arg1);
                        g unused = a.ZW = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.ZW != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.ZW.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.ZW.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.ZW = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.ZW != null) {
                        a.ZW.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.ZW = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.ZW != null) {
                        a.ZW.ay(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.ZW != null) {
                        a.ZW.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.ZW = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.ZW != null) {
                        a.ZW.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.ZW = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.ZW != null) {
                        a.ZW.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.ZW = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.ZW != null) {
                        a.ZW.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.ZW = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.ZW != null) {
                        a.ZW.az(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.ZW != null) {
                        a.ZW.on();
                        break;
                    }
                    break;
                default:
                    if (a.ZW != null) {
                        a.ZW.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.ZW = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.ZT = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - ZX < 1000) {
            return false;
        }
        ZX = System.currentTimeMillis();
        if (ZT == 0) {
            if (ZU == null) {
                ZU = new b(mHandler);
            }
            ZV = str;
            ZW = gVar;
            if (ZU.q(str, i)) {
                ZT = 3;
                new Thread(ZU).start();
                return true;
            }
            ZU = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (ZU != null) {
            ZU.stop();
        }
        ZT = 0;
    }

    public static void cancel() {
        if (ZU != null) {
            ZU.cancel();
        }
        ZT = 0;
    }
}
