package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b RW;
    private static c RX;
    private static String mFileName;
    private static int RV = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.RX != null) {
                        a.RX.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.RX != null) {
                        a.RX.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.RX != null) {
                        a.RX.aE(message.arg1);
                    }
                    return true;
                default:
                    if (a.RX != null) {
                        a.RX.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.RV = 0;
            c unused2 = a.RX = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (RV == 0) {
            if (RW == null) {
                RW = new b(mHandler, i);
            } else {
                RW.aD(i);
            }
            mFileName = str;
            RX = cVar;
            RW.ck(str);
            RV = 2;
            new Thread(RW).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (RW != null) {
            RW.stop();
        } else {
            RV = 0;
        }
    }
}
