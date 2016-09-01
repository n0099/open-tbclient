package com.baidu.tbadk.core.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class av implements Handler.Callback {
    final /* synthetic */ au aio;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.aio = auVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj instanceof TextureVideoView) {
                ((TextureVideoView) obj).stopPlayback();
            }
        }
        return true;
    }
}
