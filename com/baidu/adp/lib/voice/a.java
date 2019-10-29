package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b rP;
    private static c rQ;
    private static int rO = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.rQ != null) {
                        a.rQ.e(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.rQ != null) {
                        a.rQ.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.rQ != null) {
                        a.rQ.T(message.arg1);
                    }
                    return true;
                default:
                    if (a.rQ != null) {
                        a.rQ.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.rO = 0;
            c unused2 = a.rQ = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (rO == 0) {
            if (rP == null) {
                rP = new b(mHandler, i);
            } else {
                rP.S(i);
            }
            mFileName = str;
            rQ = cVar;
            rP.aw(str);
            rO = 2;
            new Thread(rP).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (rP != null) {
            rP.stop();
        } else {
            rO = 0;
        }
    }
}
