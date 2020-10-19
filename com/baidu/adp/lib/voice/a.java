package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static c PD;
    private static b Pz;
    private static String mFileName;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.PD != null) {
                        a.PD.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.PD != null) {
                        a.PD.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.PD != null) {
                        a.PD.aA(message.arg1);
                    }
                    return true;
                default:
                    if (a.PD != null) {
                        a.PD.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.PD = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (Pz == null) {
                Pz = new b(mHandler, i);
            } else {
                Pz.az(i);
            }
            mFileName = str;
            PD = cVar;
            Pz.cj(str);
            mPlayingState = 2;
            new Thread(Pz).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Pz != null) {
            Pz.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
