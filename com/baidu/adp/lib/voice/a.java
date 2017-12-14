package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b yT;
    private static c yU;
    private static int yS = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.yU != null) {
                        a.yU.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.yU != null) {
                        a.yU.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.yU != null) {
                        a.yU.az(message.arg1);
                    }
                    return true;
                default:
                    if (a.yU != null) {
                        a.yU.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.yS = 0;
            c unused2 = a.yU = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (yS == 0) {
            if (yT == null) {
                yT = new b(mHandler, i);
            } else {
                yT.ay(i);
            }
            mFileName = str;
            yU = cVar;
            yT.aU(str);
            yS = 2;
            new Thread(yT).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (yT != null) {
            yT.stop();
        } else {
            yS = 0;
        }
    }
}
