package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b ana;
    private static c anb;
    private static String mFileName;
    private static int amZ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.anb != null) {
                        a.anb.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.anb != null) {
                        a.anb.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.anb != null) {
                        a.anb.dt(message.arg1);
                    }
                    return true;
                default:
                    if (a.anb != null) {
                        a.anb.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.amZ = 0;
            c unused2 = a.anb = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (amZ == 0) {
            if (ana == null) {
                ana = new b(mHandler, i);
            } else {
                ana.ds(i);
            }
            mFileName = str;
            anb = cVar;
            ana.bc(str);
            amZ = 2;
            new Thread(ana).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (ana != null) {
            ana.stop();
        } else {
            amZ = 0;
        }
    }
}
