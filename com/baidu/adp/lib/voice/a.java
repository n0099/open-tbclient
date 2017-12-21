package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b yU;
    private static c yV;
    private static int yT = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.yV != null) {
                        a.yV.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.yV != null) {
                        a.yV.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.yV != null) {
                        a.yV.az(message.arg1);
                    }
                    return true;
                default:
                    if (a.yV != null) {
                        a.yV.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.yT = 0;
            c unused2 = a.yV = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (yT == 0) {
            if (yU == null) {
                yU = new b(mHandler, i);
            } else {
                yU.ay(i);
            }
            mFileName = str;
            yV = cVar;
            yU.aU(str);
            yT = 2;
            new Thread(yU).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yU != null) {
            yU.stop();
        } else {
            yT = 0;
        }
    }
}
