package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b GN;
    private static c GO;
    private static String mFileName;
    private static int GM = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.GO != null) {
                        a.GO.p(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.GO != null) {
                        a.GO.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.GO != null) {
                        a.GO.aE(message.arg1);
                    }
                    return true;
                default:
                    if (a.GO != null) {
                        a.GO.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.GM = 0;
            c unused2 = a.GO = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (GM == 0) {
            if (GN == null) {
                GN = new b(mHandler, i);
            } else {
                GN.aD(i);
            }
            mFileName = str;
            GO = cVar;
            GN.bE(str);
            GM = 2;
            new Thread(GN).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (GN != null) {
            GN.stop();
        } else {
            GM = 0;
        }
    }
}
