package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b GK;
    private static c GL;
    private static String mFileName;
    private static int GJ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.GL != null) {
                        a.GL.p(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.GL != null) {
                        a.GL.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.GL != null) {
                        a.GL.aD(message.arg1);
                    }
                    return true;
                default:
                    if (a.GL != null) {
                        a.GL.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.GJ = 0;
            c unused2 = a.GL = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (GJ == 0) {
            if (GK == null) {
                GK = new b(mHandler, i);
            } else {
                GK.aC(i);
            }
            mFileName = str;
            GL = cVar;
            GK.bE(str);
            GJ = 2;
            new Thread(GK).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (GK != null) {
            GK.stop();
        } else {
            GJ = 0;
        }
    }
}
