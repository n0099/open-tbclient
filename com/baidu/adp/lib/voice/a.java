package com.baidu.adp.lib.voice;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class a {
    private static b Ok;
    private static c Ol;
    private static String mFileName;
    private static int mPlayingState = 0;
    private static Handler mHandler = new Handler(new Handler.Callback() { // from class: com.baidu.adp.lib.voice.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (a.Ol != null) {
                        a.Ol.l(a.mFileName, message.arg1);
                        break;
                    }
                    break;
                case 1:
                    if (a.Ol != null) {
                        a.Ol.error(message.what, h.getString(R.string.voice_err_no_file));
                        break;
                    }
                    break;
                case 6:
                    if (a.Ol != null) {
                        a.Ol.av(message.arg1);
                    }
                    return true;
                default:
                    if (a.Ol != null) {
                        a.Ol.error(message.what, h.getString(R.string.voice_err_play));
                        break;
                    }
                    break;
            }
            int unused = a.mPlayingState = 0;
            c unused2 = a.Ol = null;
            return false;
        }
    });

    public static boolean a(String str, c cVar, int i) {
        if (mPlayingState == 0) {
            if (Ok == null) {
                Ok = new b(mHandler, i);
            } else {
                Ok.au(i);
            }
            mFileName = str;
            Ol = cVar;
            Ok.cb(str);
            mPlayingState = 2;
            new Thread(Ok).start();
            return true;
        }
        return false;
    }

    public static void stop() {
        if (Ok != null) {
            Ok.stop();
        } else {
            mPlayingState = 0;
        }
    }
}
