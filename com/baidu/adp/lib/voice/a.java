package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b yV;
    private static c yW;
    private static int yU = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.yW != null) {
                        a.yW.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.yW != null) {
                        a.yW.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.yW != null) {
                        a.yW.aA(message.arg1);
                    }
                    return true;
                default:
                    if (a.yW != null) {
                        a.yW.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.yU = 0;
            c unused2 = a.yW = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (yU == 0) {
            if (yV == null) {
                yV = new b(mHandler, i);
            } else {
                yV.az(i);
            }
            mFileName = str;
            yW = cVar;
            yV.aU(str);
            yU = 2;
            new Thread(yV).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yV != null) {
            yV.stop();
        } else {
            yU = 0;
        }
    }
}
