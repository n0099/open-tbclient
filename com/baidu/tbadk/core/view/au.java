package com.baidu.tbadk.core.view;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class au implements Handler.Callback {
    final /* synthetic */ at aeF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar) {
        this.aeF = atVar;
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
