package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b ane;
    private static c anf;
    private static String mFileName;
    private static int and = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.anf != null) {
                        a.anf.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.anf != null) {
                        a.anf.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.anf != null) {
                        a.anf.dt(message.arg1);
                    }
                    return true;
                default:
                    if (a.anf != null) {
                        a.anf.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.and = 0;
            c unused2 = a.anf = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (and == 0) {
            if (ane == null) {
                ane = new b(mHandler, i);
            } else {
                ane.ds(i);
            }
            mFileName = str;
            anf = cVar;
            ane.bc(str);
            and = 2;
            new Thread(ane).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (ane != null) {
            ane.stop();
        } else {
            and = 0;
        }
    }
}
