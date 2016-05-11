package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Handler.Callback {
    final /* synthetic */ at aee;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.aee = atVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        int i2;
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj instanceof MediaPlayer) {
                MediaPlayer mediaPlayer = (MediaPlayer) obj;
                mediaPlayer.reset();
                mediaPlayer.release();
                at atVar = this.aee;
                i = atVar.aea;
                atVar.aea = i - 1;
                i2 = this.aee.aea;
                if (i2 < 0) {
                    this.aee.aea = 0;
                }
            }
        }
        return true;
    }
}
