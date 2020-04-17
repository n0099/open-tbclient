package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b Nu;
    private static c Nv;
    private static String mFileName;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Nv != null) {
                        a.Nv.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.Nv != null) {
                        a.Nv.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.Nv != null) {
                        a.Nv.am(message.arg1);
                    }
                    return true;
                default:
                    if (a.Nv != null) {
                        a.Nv.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.Nv = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (Nu == null) {
                Nu = new b(mHandler, i);
            } else {
                Nu.al(i);
            }
            mFileName = str;
            Nv = cVar;
            Nu.cb(str);
            mPlayingState = 2;
            new Thread(Nu).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Nu != null) {
            Nu.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
