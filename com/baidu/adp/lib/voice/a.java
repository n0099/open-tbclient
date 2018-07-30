package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b DI;
    private static c DJ;
    private static String mFileName;
    private static int DH = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.DJ != null) {
                        a.DJ.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.DJ != null) {
                        a.DJ.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.DJ != null) {
                        a.DJ.av(message.arg1);
                    }
                    return true;
                default:
                    if (a.DJ != null) {
                        a.DJ.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.DH = 0;
            c unused2 = a.DJ = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (DH == 0) {
            if (DI == null) {
                DI = new b(mHandler, i);
            } else {
                DI.au(i);
            }
            mFileName = str;
            DJ = cVar;
            DI.bo(str);
            DH = 2;
            new Thread(DI).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (DI != null) {
            DI.stop();
        } else {
            DH = 0;
        }
    }
}
