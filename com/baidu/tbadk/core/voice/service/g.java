package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ MyAudioRecorder anS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyAudioRecorder myAudioRecorder) {
        this.anS = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.anS.xn();
    }
}
