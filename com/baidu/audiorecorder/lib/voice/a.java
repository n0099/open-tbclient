package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class a {
    private static b acj;
    private static String acm;
    private static g acn;
    private static int aci = 0;
    private static long aco = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.audiorecorder.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.acn != null) {
                        a.acn.m(a.acm, message.arg1);
                        g unused = a.acn = null;
                        break;
                    }
                    break;
                case 1:
                case 3:
                    if (a.acn != null) {
                        if (com.baidu.adp.lib.util.f.checkSDHasSpace()) {
                            a.acn.error(message.what, h.getString(R.string.voice_err_create_file_fail));
                        } else {
                            a.acn.error(message.what, h.getString(R.string.voice_err_sdcard_nospace));
                        }
                        g unused2 = a.acn = null;
                        break;
                    }
                    break;
                case 2:
                    if (a.acn != null) {
                        a.acn.error(message.what, h.getString(R.string.voice_err_file_fail));
                        g unused3 = a.acn = null;
                        break;
                    }
                    break;
                case 4:
                    if (a.acn != null) {
                        a.acn.aF(message.arg1);
                        break;
                    }
                    break;
                case 5:
                    if (a.acn != null) {
                        a.acn.error(message.what, h.getString(R.string.voice_err_load_lib_fail));
                        g unused4 = a.acn = null;
                        break;
                    }
                    break;
                case 6:
                    if (a.acn != null) {
                        a.acn.error(message.what, h.getString(R.string.voice_err_init_fail));
                        g unused5 = a.acn = null;
                        break;
                    }
                    break;
                case 7:
                    if (a.acn != null) {
                        a.acn.error(message.what, h.getString(R.string.voice_record_timeout_tip));
                        g unused6 = a.acn = null;
                        break;
                    }
                    break;
                case 8:
                    if (a.acn != null) {
                        a.acn.error(message.what, h.getString(R.string.voice_record_short_tip));
                        g unused7 = a.acn = null;
                        break;
                    }
                    break;
                case 9:
                    if (a.acn != null) {
                        a.acn.aG(message.arg1);
                        break;
                    }
                    break;
                case 100:
                    if (a.acn != null) {
                        a.acn.nS();
                        break;
                    }
                    break;
                default:
                    if (a.acn != null) {
                        a.acn.error(message.what, h.getString(R.string.voice_err_other));
                        g unused8 = a.acn = null;
                        break;
                    }
                    break;
            }
            int unused9 = a.aci = 0;
            return false;
        }
    });

    public static boolean a(String str, int i, g gVar) {
        if (System.currentTimeMillis() - aco < 1000) {
            return false;
        }
        aco = System.currentTimeMillis();
        if (aci == 0) {
            if (acj == null) {
                acj = new b(mHandler);
            }
            acm = str;
            acn = gVar;
            if (acj.q(str, i)) {
                aci = 3;
                new Thread(acj).start();
                return true;
            }
            acj = null;
            return false;
        }
        return false;
    }

    public static void stop() {
        if (acj != null) {
            acj.stop();
        }
        aci = 0;
    }

    public static void cancel() {
        if (acj != null) {
            acj.cancel();
        }
        aci = 0;
    }
}
