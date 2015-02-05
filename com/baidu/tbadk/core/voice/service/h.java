package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ MyAudioRecorder OV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MyAudioRecorder myAudioRecorder) {
        this.OV = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.OV.qQ();
    }
}
