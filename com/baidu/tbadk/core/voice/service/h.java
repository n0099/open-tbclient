package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ MyAudioRecorder abd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MyAudioRecorder myAudioRecorder) {
        this.abd = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.abd.uI();
    }
}
