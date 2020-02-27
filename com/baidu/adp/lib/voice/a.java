package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static String mFileName;
    private static b uF;
    private static c uG;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.uG != null) {
                        a.uG.h(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.uG != null) {
                        a.uG.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.uG != null) {
                        a.uG.aa(message.arg1);
                    }
                    return true;
                default:
                    if (a.uG != null) {
                        a.uG.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.uG = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (uF == null) {
                uF = new b(mHandler, i);
            } else {
                uF.Z(i);
            }
            mFileName = str;
            uG = cVar;
            uF.aM(str);
            mPlayingState = 2;
            new Thread(uF).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (uF != null) {
            uF.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
