package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b anf;
    private static c ang;
    private static String mFileName;
    private static int ane = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.ang != null) {
                        a.ang.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.ang != null) {
                        a.ang.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.ang != null) {
                        a.ang.dt(message.arg1);
                    }
                    return true;
                default:
                    if (a.ang != null) {
                        a.ang.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.ane = 0;
            c unused2 = a.ang = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (ane == 0) {
            if (anf == null) {
                anf = new b(mHandler, i);
            } else {
                anf.ds(i);
            }
            mFileName = str;
            ang = cVar;
            anf.bc(str);
            ane = 2;
            new Thread(anf).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (anf != null) {
            anf.stop();
        } else {
            ane = 0;
        }
    }
}
