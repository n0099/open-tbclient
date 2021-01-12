package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b QC;
    private static c QD;
    private static String mFileName;
    private static int QB = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.QD != null) {
                        a.QD.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.QD != null) {
                        a.QD.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.QD != null) {
                        a.QD.aE(message.arg1);
                    }
                    return true;
                default:
                    if (a.QD != null) {
                        a.QD.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.QB = 0;
            c unused2 = a.QD = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (QB == 0) {
            if (QC == null) {
                QC = new b(mHandler, i);
            } else {
                QC.aD(i);
            }
            mFileName = str;
            QD = cVar;
            QC.cg(str);
            QB = 2;
            new Thread(QC).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (QC != null) {
            QC.stop();
        } else {
            QB = 0;
        }
    }
}
