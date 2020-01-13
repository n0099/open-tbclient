package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b um;
    private static c uo;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.uo != null) {
                        a.uo.h(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.uo != null) {
                        a.uo.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.uo != null) {
                        a.uo.X(message.arg1);
                    }
                    return true;
                default:
                    if (a.uo != null) {
                        a.uo.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.uo = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (um == null) {
                um = new b(mHandler, i);
            } else {
                um.W(i);
            }
            mFileName = str;
            uo = cVar;
            um.aI(str);
            mPlayingState = 2;
            new Thread(um).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (um != null) {
            um.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
