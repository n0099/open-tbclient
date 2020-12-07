package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b QB;
    private static c QC;
    private static String mFileName;
    private static int Qz = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.QC != null) {
                        a.QC.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.QC != null) {
                        a.QC.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.QC != null) {
                        a.QC.aD(message.arg1);
                    }
                    return true;
                default:
                    if (a.QC != null) {
                        a.QC.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.Qz = 0;
            c unused2 = a.QC = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (Qz == 0) {
            if (QB == null) {
                QB = new b(mHandler, i);
            } else {
                QB.aC(i);
            }
            mFileName = str;
            QC = cVar;
            QB.cn(str);
            Qz = 2;
            new Thread(QB).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (QB != null) {
            QB.stop();
        } else {
            Qz = 0;
        }
    }
}
