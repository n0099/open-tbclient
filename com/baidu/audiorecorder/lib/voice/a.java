package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class a {
    private static b aan;
    private static String aao;
    private static g aap;
    private static int aam = 0;
    private static long aaq = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.aap != null) {
                        a.aap.m(a.aao, message.arg1);
                        g unused = a.aap = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.aap != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.aap.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.aap.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.aap = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.aap != null) {
                        a.aap.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.aap = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.aap != null) {
                        a.aap.aB(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.aap != null) {
                        a.aap.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.aap = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.aap != null) {
                        a.aap.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.aap = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.aap != null) {
                        a.aap.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.aap = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.aap != null) {
                        a.aap.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.aap = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.aap != null) {
                        a.aap.aC(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.aap != null) {
                        a.aap.os();
                        break;
                    }
                    break;
                default:
                    if (a.aap != null) {
                        a.aap.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.aap = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.aam = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - aaq < 1000) {
            return false;
        }
        aaq = System.currentTimeMillis();
        if (aam == 0) {
            if (aan == null) {
                aan = new b(mHandler);
            }
            aao = str;
            aap = gVar;
            if (aan.q(str, i)) {
                aam = 3;
                new Thread(aan).start();
                return true;
            }
            aan = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (aan != null) {
            aan.stop();
        }
        aam = 0;
    }

    public static void cancel() {
        if (aan != null) {
            aan.cancel();
        }
        aam = 0;
    }
}
