package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MyAudioRecorder Jm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyAudioRecorder myAudioRecorder) {
        this.Jm = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Jm.nK();
    }
}
