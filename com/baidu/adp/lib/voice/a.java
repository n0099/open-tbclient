package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b zx;
    private static c zy;
    private static int zw = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.zy != null) {
                        a.zy.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.zy != null) {
                        a.zy.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.zy != null) {
                        a.zy.ax(message.arg1);
                    }
                    return true;
                default:
                    if (a.zy != null) {
                        a.zy.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.zw = 0;
            c unused2 = a.zy = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (zw == 0) {
            if (zx == null) {
                zx = new b(mHandler, i);
            } else {
                zx.aw(i);
            }
            mFileName = str;
            zy = cVar;
            zx.aR(str);
            zw = 2;
            new Thread(zx).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (zx != null) {
            zx.stop();
        } else {
            zw = 0;
        }
    }
}
