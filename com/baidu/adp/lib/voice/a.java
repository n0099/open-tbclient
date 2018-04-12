package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b xD;
    private static c xE;
    private static int xC = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.xE != null) {
                        a.xE.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.xE != null) {
                        a.xE.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.xE != null) {
                        a.xE.at(message.arg1);
                    }
                    return true;
                default:
                    if (a.xE != null) {
                        a.xE.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.xC = 0;
            c unused2 = a.xE = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (xC == 0) {
            if (xD == null) {
                xD = new b(mHandler, i);
            } else {
                xD.as(i);
            }
            mFileName = str;
            xE = cVar;
            xD.aZ(str);
            xC = 2;
            new Thread(xD).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (xD != null) {
            xD.stop();
        } else {
            xC = 0;
        }
    }
}
