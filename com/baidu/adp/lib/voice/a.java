package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b Ey;
    private static c Ez;
    private static String mFileName;
    private static int Ex = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Ez != null) {
                        a.Ez.j(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.Ez != null) {
                        a.Ez.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.Ez != null) {
                        a.Ez.aw(message.arg1);
                    }
                    return true;
                default:
                    if (a.Ez != null) {
                        a.Ez.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.Ex = 0;
            c unused2 = a.Ez = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (Ex == 0) {
            if (Ey == null) {
                Ey = new b(mHandler, i);
            } else {
                Ey.av(i);
            }
            mFileName = str;
            Ez = cVar;
            Ey.bo(str);
            Ex = 2;
            new Thread(Ey).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Ey != null) {
            Ey.stop();
        } else {
            Ex = 0;
        }
    }
}
