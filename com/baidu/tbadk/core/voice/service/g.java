package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ MyAudioRecorder aju;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyAudioRecorder myAudioRecorder) {
        this.aju = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aju.ya();
    }
}
