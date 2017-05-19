package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ MyAudioRecorder aol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyAudioRecorder myAudioRecorder) {
        this.aol = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aol.wX();
    }
}
