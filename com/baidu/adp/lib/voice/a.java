package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b GO;
    private static c GP;
    private static String mFileName;
    private static int GN = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.GP != null) {
                        a.GP.p(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.GP != null) {
                        a.GP.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.GP != null) {
                        a.GP.aU(message.arg1);
                    }
                    return true;
                default:
                    if (a.GP != null) {
                        a.GP.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.GN = 0;
            c unused2 = a.GP = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (GN == 0) {
            if (GO == null) {
                GO = new b(mHandler, i);
            } else {
                GO.aT(i);
            }
            mFileName = str;
            GP = cVar;
            GO.bE(str);
            GN = 2;
            new Thread(GO).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (GO != null) {
            GO.stop();
        } else {
            GN = 0;
        }
    }
}
