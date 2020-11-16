package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b PE;
    private static c PF;
    private static String mFileName;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.PF != null) {
                        a.PF.m(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.PF != null) {
                        a.PF.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.PF != null) {
                        a.PF.aA(message.arg1);
                    }
                    return true;
                default:
                    if (a.PF != null) {
                        a.PF.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.PF = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (PE == null) {
                PE = new b(mHandler, i);
            } else {
                PE.az(i);
            }
            mFileName = str;
            PF = cVar;
            PE.ck(str);
            mPlayingState = 2;
            new Thread(PE).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (PE != null) {
            PE.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
