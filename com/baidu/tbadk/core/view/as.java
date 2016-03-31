package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Handler.Callback {
    final /* synthetic */ ar aif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar) {
        this.aif = arVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj instanceof MediaPlayer) {
                MediaPlayer mediaPlayer = (MediaPlayer) obj;
                mediaPlayer.reset();
                mediaPlayer.release();
            }
        }
        return true;
    }
}
