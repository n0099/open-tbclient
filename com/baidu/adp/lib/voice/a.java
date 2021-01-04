package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b QE;
    private static c QF;
    private static String mFileName;
    private static int QD = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.QF != null) {
                        a.QF.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.QF != null) {
                        a.QF.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.QF != null) {
                        a.QF.aE(message.arg1);
                    }
                    return true;
                default:
                    if (a.QF != null) {
                        a.QF.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.QD = 0;
            c unused2 = a.QF = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (QD == 0) {
            if (QE == null) {
                QE = new b(mHandler, i);
            } else {
                QE.aD(i);
            }
            mFileName = str;
            QF = cVar;
            QE.cg(str);
            QD = 2;
            new Thread(QE).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (QE != null) {
            QE.stop();
        } else {
            QD = 0;
        }
    }
}
