package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b uh;
    private static c uj;
    private static int ug = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.uj != null) {
                        a.uj.h(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.uj != null) {
                        a.uj.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.uj != null) {
                        a.uj.X(message.arg1);
                    }
                    return true;
                default:
                    if (a.uj != null) {
                        a.uj.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.ug = 0;
            c unused2 = a.uj = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (ug == 0) {
            if (uh == null) {
                uh = new b(mHandler, i);
            } else {
                uh.W(i);
            }
            mFileName = str;
            uj = cVar;
            uh.aI(str);
            ug = 2;
            new Thread(uh).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (uh != null) {
            uh.stop();
        } else {
            ug = 0;
        }
    }
}
