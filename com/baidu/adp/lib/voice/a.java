package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b AY;
    private static c AZ;
    private static String mFileName;
    private static int AX = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.AZ != null) {
                        a.AZ.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.AZ != null) {
                        a.AZ.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.AZ != null) {
                        a.AZ.aA(message.arg1);
                    }
                    return true;
                default:
                    if (a.AZ != null) {
                        a.AZ.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.AX = 0;
            c unused2 = a.AZ = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (AX == 0) {
            if (AY == null) {
                AY = new b(mHandler, i);
            } else {
                AY.az(i);
            }
            mFileName = str;
            AZ = cVar;
            AY.aX(str);
            AX = 2;
            new Thread(AY).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (AY != null) {
            AY.stop();
        } else {
            AX = 0;
        }
    }
}
