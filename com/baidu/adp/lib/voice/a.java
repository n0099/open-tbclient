package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b Ba;
    private static c Bb;
    private static String mFileName;
    private static int AZ = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Bb != null) {
                        a.Bb.k(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.Bb != null) {
                        a.Bb.f(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.Bb != null) {
                        a.Bb.aA(message.arg1);
                    }
                    return true;
                default:
                    if (a.Bb != null) {
                        a.Bb.f(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.AZ = 0;
            c unused2 = a.Bb = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (AZ == 0) {
            if (Ba == null) {
                Ba = new b(mHandler, i);
            } else {
                Ba.az(i);
            }
            mFileName = str;
            Bb = cVar;
            Ba.aX(str);
            AZ = 2;
            new Thread(Ba).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Ba != null) {
            Ba.stop();
        } else {
            AZ = 0;
        }
    }
}
