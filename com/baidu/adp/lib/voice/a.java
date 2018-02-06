package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b ang;
    private static c anh;
    private static String mFileName;
    private static int anf = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.anh != null) {
                        a.anh.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.anh != null) {
                        a.anh.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.anh != null) {
                        a.anh.dt(message.arg1);
                    }
                    return true;
                default:
                    if (a.anh != null) {
                        a.anh.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.anf = 0;
            c unused2 = a.anh = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (anf == 0) {
            if (ang == null) {
                ang = new b(mHandler, i);
            } else {
                ang.ds(i);
            }
            mFileName = str;
            anh = cVar;
            ang.bc(str);
            anf = 2;
            new Thread(ang).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (ang != null) {
            ang.stop();
        } else {
            anf = 0;
        }
    }
}
