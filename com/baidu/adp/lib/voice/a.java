package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static c QB;
    private static b Qz;
    private static String mFileName;
    private static int Qy = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.QB != null) {
                        a.QB.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.QB != null) {
                        a.QB.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.QB != null) {
                        a.QB.aE(message.arg1);
                    }
                    return true;
                default:
                    if (a.QB != null) {
                        a.QB.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.Qy = 0;
            c unused2 = a.QB = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (Qy == 0) {
            if (Qz == null) {
                Qz = new b(mHandler, i);
            } else {
                Qz.aD(i);
            }
            mFileName = str;
            QB = cVar;
            Qz.cg(str);
            Qy = 2;
            new Thread(Qz).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Qz != null) {
            Qz.stop();
        } else {
            Qy = 0;
        }
    }
}
