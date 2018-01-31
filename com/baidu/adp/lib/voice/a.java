package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b anh;
    private static c ani;
    private static String mFileName;
    private static int ang = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.ani != null) {
                        a.ani.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.ani != null) {
                        a.ani.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.ani != null) {
                        a.ani.dt(message.arg1);
                    }
                    return true;
                default:
                    if (a.ani != null) {
                        a.ani.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.ang = 0;
            c unused2 = a.ani = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (ang == 0) {
            if (anh == null) {
                anh = new b(mHandler, i);
            } else {
                anh.ds(i);
            }
            mFileName = str;
            ani = cVar;
            anh.bc(str);
            ang = 2;
            new Thread(anh).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (anh != null) {
            anh.stop();
        } else {
            ang = 0;
        }
    }
}
