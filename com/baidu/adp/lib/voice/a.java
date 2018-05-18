package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b xC;
    private static c xD;
    private static int xB = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.xD != null) {
                        a.xD.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.xD != null) {
                        a.xD.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.xD != null) {
                        a.xD.at(message.arg1);
                    }
                    return true;
                default:
                    if (a.xD != null) {
                        a.xD.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.xB = 0;
            c unused2 = a.xD = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (xB == 0) {
            if (xC == null) {
                xC = new b(mHandler, i);
            } else {
                xC.as(i);
            }
            mFileName = str;
            xD = cVar;
            xC.aZ(str);
            xB = 2;
            new Thread(xC).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (xC != null) {
            xC.stop();
        } else {
            xB = 0;
        }
    }
}
