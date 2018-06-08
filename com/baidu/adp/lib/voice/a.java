package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b DJ;
    private static c DK;
    private static String mFileName;
    private static int DI = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.DK != null) {
                        a.DK.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.DK != null) {
                        a.DK.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.DK != null) {
                        a.DK.au(message.arg1);
                    }
                    return true;
                default:
                    if (a.DK != null) {
                        a.DK.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.DI = 0;
            c unused2 = a.DK = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (DI == 0) {
            if (DJ == null) {
                DJ = new b(mHandler, i);
            } else {
                DJ.at(i);
            }
            mFileName = str;
            DK = cVar;
            DJ.bl(str);
            DI = 2;
            new Thread(DJ).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (DJ != null) {
            DJ.stop();
        } else {
            DI = 0;
        }
    }
}
