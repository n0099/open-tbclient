package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes.dex */
public class ar {
    private static ar aic = new ar();
    private Handler aid;
    private Handler.Callback aie = new as(this);

    public static ar xN() {
        return aic;
    }

    private ar() {
        HandlerThread handlerThread = new HandlerThread("release_media");
        handlerThread.start();
        this.aid = new Handler(handlerThread.getLooper(), this.aie);
    }

    public void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = mediaPlayer;
            this.aid.sendMessage(obtain);
        }
    }
}
