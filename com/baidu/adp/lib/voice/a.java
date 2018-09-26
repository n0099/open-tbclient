package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b Gd;
    private static c Ge;
    private static String mFileName;
    private static int Gc = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Ge != null) {
                        a.Ge.p(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.Ge != null) {
                        a.Ge.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.Ge != null) {
                        a.Ge.aD(message.arg1);
                    }
                    return true;
                default:
                    if (a.Ge != null) {
                        a.Ge.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.Gc = 0;
            c unused2 = a.Ge = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (Gc == 0) {
            if (Gd == null) {
                Gd = new b(mHandler, i);
            } else {
                Gd.aC(i);
            }
            mFileName = str;
            Ge = cVar;
            Gd.bF(str);
            Gc = 2;
            new Thread(Gd).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Gd != null) {
            Gd.stop();
        } else {
            Gc = 0;
        }
    }
}
