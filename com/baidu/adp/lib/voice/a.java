package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b EF;
    private static c EG;
    private static String mFileName;
    private static int EE = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.EG != null) {
                        a.EG.j(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.EG != null) {
                        a.EG.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.EG != null) {
                        a.EG.aw(message.arg1);
                    }
                    return true;
                default:
                    if (a.EG != null) {
                        a.EG.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.EE = 0;
            c unused2 = a.EG = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (EE == 0) {
            if (EF == null) {
                EF = new b(mHandler, i);
            } else {
                EF.av(i);
            }
            mFileName = str;
            EG = cVar;
            EF.bp(str);
            EE = 2;
            new Thread(EF).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (EF != null) {
            EF.stop();
        } else {
            EE = 0;
        }
    }
}
