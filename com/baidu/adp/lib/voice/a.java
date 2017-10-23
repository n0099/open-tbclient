package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b yW;
    private static c yX;
    private static int yV = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.yX != null) {
                        a.yX.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.yX != null) {
                        a.yX.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.yX != null) {
                        a.yX.aA(message.arg1);
                    }
                    return true;
                default:
                    if (a.yX != null) {
                        a.yX.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.yV = 0;
            c unused2 = a.yX = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (yV == 0) {
            if (yW == null) {
                yW = new b(mHandler, i);
            } else {
                yW.az(i);
            }
            mFileName = str;
            yX = cVar;
            yW.aU(str);
            yV = 2;
            new Thread(yW).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yW != null) {
            yW.stop();
        } else {
            yV = 0;
        }
    }
}
