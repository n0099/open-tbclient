package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static c EA;
    private static b Ez;
    private static String mFileName;
    private static int Ey = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.EA != null) {
                        a.EA.j(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.EA != null) {
                        a.EA.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.EA != null) {
                        a.EA.aw(message.arg1);
                    }
                    return true;
                default:
                    if (a.EA != null) {
                        a.EA.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.Ey = 0;
            c unused2 = a.EA = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (Ey == 0) {
            if (Ez == null) {
                Ez = new b(mHandler, i);
            } else {
                Ez.av(i);
            }
            mFileName = str;
            EA = cVar;
            Ez.bo(str);
            Ey = 2;
            new Thread(Ez).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Ez != null) {
            Ez.stop();
        } else {
            Ey = 0;
        }
    }
}
