package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b DL;
    private static c DM;
    private static String mFileName;
    private static int DK = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.DM != null) {
                        a.DM.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.DM != null) {
                        a.DM.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.DM != null) {
                        a.DM.au(message.arg1);
                    }
                    return true;
                default:
                    if (a.DM != null) {
                        a.DM.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.DK = 0;
            c unused2 = a.DM = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (DK == 0) {
            if (DL == null) {
                DL = new b(mHandler, i);
            } else {
                DL.at(i);
            }
            mFileName = str;
            DM = cVar;
            DL.bn(str);
            DK = 2;
            new Thread(DL).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (DL != null) {
            DL.stop();
        } else {
            DK = 0;
        }
    }
}
