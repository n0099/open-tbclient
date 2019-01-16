package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a {
    private static b SA;
    private static String SB;
    private static g SC;
    private static int Sz = 0;
    private static long SD = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.SC != null) {
                        a.SC.p(a.SB, message.arg1);
                        g unused = a.SC = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.SC != null) {
                        if (com.baidu.adp.lib.util.f.kG()) {
                            a.SC.error(message.what, h.getString(e.j.voice_err_create_file_fail));
                        } else {
                            a.SC.error(message.what, h.getString(e.j.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.SC = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.SC != null) {
                        a.SC.error(message.what, h.getString(e.j.voice_err_file_fail));
                        g unused3 = a.SC = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.SC != null) {
                        a.SC.aV(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.SC != null) {
                        a.SC.error(message.what, h.getString(e.j.voice_err_load_lib_fail));
                        g unused4 = a.SC = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.SC != null) {
                        a.SC.error(message.what, h.getString(e.j.voice_err_init_fail));
                        g unused5 = a.SC = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.SC != null) {
                        a.SC.error(message.what, h.getString(e.j.voice_record_timeout_tip));
                        g unused6 = a.SC = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.SC != null) {
                        a.SC.error(message.what, h.getString(e.j.voice_record_short_tip));
                        g unused7 = a.SC = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.SC != null) {
                        a.SC.aW(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.SC != null) {
                        a.SC.lw();
                        break;
                    }
                    break;
                default:
                    if (a.SC != null) {
                        a.SC.error(message.what, h.getString(e.j.voice_err_other));
                        g unused8 = a.SC = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.Sz = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - SD < 1000) {
            return false;
        }
        SD = System.currentTimeMillis();
        if (Sz == 0) {
            if (SA == null) {
                SA = new b(mHandler);
            }
            SB = str;
            SC = gVar;
            if (SA.t(str, i)) {
                Sz = 3;
                new Thread(SA).start();
                return true;
            }
            SA = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (SA != null) {
            SA.stop();
        }
        Sz = 0;
    }

    public static void cancel() {
        if (SA != null) {
            SA.cancel();
        }
        Sz = 0;
    }
}
