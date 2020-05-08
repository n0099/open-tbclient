package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b Ny;
    private static c Nz;
    private static String mFileName;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Nz != null) {
                        a.Nz.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.Nz != null) {
                        a.Nz.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.Nz != null) {
                        a.Nz.am(message.arg1);
                    }
                    return true;
                default:
                    if (a.Nz != null) {
                        a.Nz.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.Nz = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (Ny == null) {
                Ny = new b(mHandler, i);
            } else {
                Ny.al(i);
            }
            mFileName = str;
            Nz = cVar;
            Ny.cb(str);
            mPlayingState = 2;
            new Thread(Ny).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Ny != null) {
            Ny.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
