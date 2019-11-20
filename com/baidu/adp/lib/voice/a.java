package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b rq;
    private static c rr;
    private static int rp = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.rr != null) {
                        a.rr.e(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.rr != null) {
                        a.rr.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.rr != null) {
                        a.rr.T(message.arg1);
                    }
                    return true;
                default:
                    if (a.rr != null) {
                        a.rr.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.rp = 0;
            c unused2 = a.rr = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (rp == 0) {
            if (rq == null) {
                rq = new b(mHandler, i);
            } else {
                rq.S(i);
            }
            mFileName = str;
            rr = cVar;
            rq.aw(str);
            rp = 2;
            new Thread(rq).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (rq != null) {
            rq.stop();
        } else {
            rp = 0;
        }
    }
}
